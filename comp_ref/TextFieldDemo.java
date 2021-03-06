import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class TextFieldDemo extends Application {
    TextField tf;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage) {
        myStage.setTitle("TextFields");

        FlowPane rootNode = new FlowPane(10, 10);

        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 230, 140);

        myStage.setScene(myScene);

        response = new Label("Enter a name: ");

        Button btnGetText = new Button("Get Name");

        tf = new TextField();

        tf.setPromptText("Enter a name.");

        tf.setPrefColumnCount(15);

        tf.setOnAction( (ae) -> response.setText("Enter pressed. Name is: " + tf.getText()));

        btnGetText.setOnAction( (ae) -> response.setText("Button pressed. Name is " + tf.getText()));

        Separator separator = new Separator();
        separator.setPrefWidth(180);

        rootNode.getChildren().addAll(tf, btnGetText, separator, response);

        myStage.show();

    }
}