package mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

		
@DisplayName("Messenger Test 2")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
public class MessengerTest2 {
	
  private static final String RANDOM_MESSAGE = "Message";
	private static final String RANDOM_EMAIL = "email@email.com";
  

	
	
	@Mock
  private TemplateEngine templateEngineMock;
	
  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private MailServer mailServerMock;
  @InjectMocks
  private Messenger messenger;
  @Captor
  private ArgumentCaptor<Email> captor;
  
  private AutoCloseable closeble;
  
  @Spy
  private ArrayList<Integer> list;

  
  
  
  @Test
 	public void shouldThrowExceptionWhenMockFinalClass() {
     	// Can't mock final class
// 		String string = mock(String.class);
// 		when(string.length()).thenReturn(20);
// 		assertThat(string.length(), equalTo(20));
 		
 		// Can't mock static method
// 		when(Map.of()).thenReturn(null);
     	
     	// Can't mock equals of hashCode
     	
 	}
  
  @Test
  void verifyVoidMethodExample() {
  	List<String> listMock = mock(List.class);
  	
  	
  	
  	
  	
  	doAnswer(methodInvocation -> {
          Object arg0 = methodInvocation.getArgument(0);
          Object arg1 = methodInvocation.getArgument(1);
          
          assertEquals(3, arg0);
          assertEquals("List Element", arg1);
          return null;
      }).when(listMock).add(any(Integer.class), any(String.class));
  	listMock.add(3, "List Element");
  }

@Test
  void spy_Example() {
  	List<Integer> listInts = new ArrayList<>();
  	List<Integer> spy = spy(listInts);
  	
 
  	
  	doReturn(0).when(spy).get(0);
  	System.out.println(spy.get(0));
  	
  	verify(spy).get(0);
  }
  
}
