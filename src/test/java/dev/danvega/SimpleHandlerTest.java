package dev.danvega;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SimpleHandlerTest {
    private SimpleHandler simpleHandler;
    @Mock
    Context context;

    @Mock
    LambdaLogger lambdaLogger;

    @BeforeEach
    public void setup() {
        when(context.getLogger()).thenReturn(lambdaLogger);
        doAnswer(call ->{
            System.out.println((String)call.getArgument(0));
            return null;
        }).when(lambdaLogger).log(anyString());

        simpleHandler = new SimpleHandler();
    }

    @Test
    void shouldReturnUppercaseOfInput() {
when(context.getFunctionName()).thenReturn("handleRequest");
        Assertions.assertEquals("HELLO,WORLD",simpleHandler.handleRequest("hello,world",context ));
    }

}