// package example.grpcClient;

// import com.google.protobuf.Empty;

// import io.grpc.stub.StreamObserver;
// import service.*;

// import java.util.ArrayList;
// import java.util.List;

// public class CalculatorImpl extends  CalculatorGrpc.CalculatorImplBase {
//     private List<Expression> history;

//     public CalculatorImpl() {
//         history = new ArrayList<>();
//     }

//     @Override
//     public void evaluate(EvaluateRequest request, StreamObserver<EvaluateResponse> responseObserver) {
//         Expression expression = request.getExpression();
//         int num1 = expression.getNum1();
//         int num2 = expression.getNum2();
//         Expression.Operation operation = expression.getOperation();

//         EvaluateResponse.Builder responseBuilder = EvaluateResponse.newBuilder();
//         int result;
//         String error = "";

//         try {
//             switch (operation) {
//                 case PLUS:
//                     result = num1 + num2;
//                     break;
//                 case MINUS:
//                     result = num1 - num2;
//                     break;
//                 case MULTIPLY:
//                     result = num1 * num2;
//                     break;
//                 case DIVIDE:
//                     if (num2 == 0) {
//                         throw new ArithmeticException("Division by zero is not allowed.");
//                     }
//                     result = num1 / num2;
//                     break;
//                 default:
//                     throw new IllegalArgumentException("Invalid operation.");
//             }
//             responseBuilder.setIsSuccess(1);
//             responseBuilder.setResult(result);
//         } catch (Exception e) {
//             responseBuilder.setIsSuccess(0);
//             responseBuilder.setError(e.getMessage());
//         }

//         responseObserver.onNext(responseBuilder.build());
//         responseObserver.onCompleted();
//     }

//     @Override
//     public void history(Empty request, StreamObserver<HistoryResponse> responseObserver) {
//         HistoryResponse.Builder responseBuilder = HistoryResponse.newBuilder();
//         responseBuilder.addAllExpressions(history);
//         responseObserver.onNext(responseBuilder.build());
//         responseObserver.onCompleted();
//     }
// }
package example.grpcClient;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import service.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl extends CalculatorGrpc.CalculatorImplBase {
    private List<Expression> history;

    public CalculatorImpl() {
        history = new ArrayList<>();
    }
    @Override
    public void evaluate(EvaluateRequest request, StreamObserver<EvaluateResponse> responseObserver) {
        Expression expression = request.getExpression();
        int num1 = expression.getNum1();
        int num2 = expression.getNum2();
        Expression.Operation operation = expression.getOperation();

        EvaluateResponse.Builder responseBuilder = EvaluateResponse.newBuilder();
        int result;
        String error = "";

        try {
            switch (operation) {
                case PLUS:
                    result = num1 + num2;
                    break;
                case MINUS:
                    result = num1 - num2;
                    break;
                case MULTIPLY:
                    result = num1 * num2;
                    break;
                case DIVIDE:
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation.");
            }
            responseBuilder.setIsSuccess(1); // Set isSuccess to 1 for true
            responseBuilder.setResult(result);

            // Add the evaluated expression to the history
            history.add(expression);
        } catch (Exception e) {
            responseBuilder.setIsSuccess(0); // Set isSuccess to 0 for false
            responseBuilder.setError(e.getMessage());
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    public void history(Empty request, StreamObserver<HistoryResponse> responseObserver) {
        // Create a HistoryResponse message with the expressions from the history list
        HistoryResponse response = HistoryResponse.newBuilder()
                .addAllExpressions(history)
                .build();
    
        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }    
    

}
