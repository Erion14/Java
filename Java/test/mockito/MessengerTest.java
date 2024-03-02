package mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessengerTest {

	private static final String RANDOM_MESSAGE = "Message";
	private static final String RANDOM_EMAIL = "email@email.com";
	@Mock
    private TemplateEngine templateEngineMock;
    @Mock
    private MailServer mailServerMock;
    @InjectMocks
    private Messenger messenger;
    @Captor
    private ArgumentCaptor<Email> captor;
    
    private AutoCloseable closeble;
    
    
    @Test
    void shouldSendMessage() {
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(client, template))
    					.thenReturn(RANDOM_MESSAGE);
    	
    	messenger.sendMessage(client, template);
    	
    	
    	verify(templateEngineMock).prepareMessage(client, template);
    	verify(mailServerMock).send(any(Email.class));
    }
    
    @Test
    void shouldSendMessageWithArgumentMatchers() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(any(Client.class), 
    			any(Template.class))).thenReturn(RANDOM_EMAIL);
    	
    	messenger.sendMessage(client, template);
    	 verify(templateEngineMock).prepareMessage(client, template);
         verify(mailServerMock).send(any(Email.class));

}
    
    @Test
    public void shouldThrowExceptionWhenTemplateEngineThrowsException() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
        when(templateEngineMock.prepareMessage(
        		client, template))
        		.thenThrow(new IllegalArgumentException());

        // when & then
        assertThrows(IllegalArgumentException.class, () -> 
        	messenger.sendMessage(client, template)
        );
    }
    
    @Test
    public void shouldSetClientEmailToAddresseInEmail() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(client, template))
    			.thenReturn(RANDOM_MESSAGE);

        messenger.sendMessage(client, template);

        verify(templateEngineMock).prepareMessage(client, template);
        verify(mailServerMock).send(captor.capture());
        assertEquals(client.getEmail(), captor.getValue().getAddressee());
    }


}