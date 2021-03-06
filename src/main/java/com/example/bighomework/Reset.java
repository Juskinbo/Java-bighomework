package com.example.bighomework;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Integer.parseInt;

public class Reset extends Application {

    @Override
    public void start(Stage warningStage) {
        File iconFile = new File("src/main/java/com/example/bighomework/icon.jpg");
        Image icon = new Image(iconFile.toURI().toString());
        AtomicInteger userNumber = new AtomicInteger();
        AtomicInteger nowUser = new AtomicInteger();
        ArrayList<User> users = new ArrayList<>();
        AtomicReference<String> ans1;
        ans1 = new AtomicReference<>();
        AtomicReference<String> ans2;
        ans2 = new AtomicReference<>();
        File informationUsersFile = new File("src/main/java/com/example/bighomework/usersinformation.txt");
        BufferedReader reader1;
        try {
            reader1 = new BufferedReader(new FileReader(informationUsersFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String str;
        while (true) {
            try {
                if ((str = reader1.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] s = str.split(" ");
            User temp = new User(s[0], s[1], s[2], s[3], s[4], s[5], s[6], parseInt(s[7]));
            users.add(temp);
            userNumber.getAndIncrement();
        }
        File backGroundFile = new File("src/main/java/com/example/bighomework/resetBackGround.jpg");
        ImageView backGround = new ImageView(backGroundFile.toURI().toString());
        Stage resetStage = new Stage();
        BorderPane warningPane = new BorderPane();
        Label warningLabel = new Label();
        Label newPasswordLabel = new Label("????????????");
        TextField warningTextField = new TextField();
        Button cancelResetButton = new Button("??????");
        Button cancelWarningButton = new Button("??????");
        GridPane resetPane = new GridPane();
        StackPane resetStackPane = new StackPane(backGround);
        Label resetSucceedLabel = new Label("?????????????????????");
        resetSucceedLabel.setTextFill(Color.GREEN);
        resetSucceedLabel.setStyle("-fx-font-size: 20");
        Button resetSucceedButton = new Button("??????");
        resetSucceedButton.setPrefSize(100, 30);
        VBox resetSucceedVBox = new VBox(resetSucceedLabel, resetSucceedButton);
        resetSucceedVBox.setSpacing(30);
        StackPane resetSucceedPane = new StackPane(resetSucceedVBox);
        Stage resetSucceedStage = new Stage();
        resetSucceedStage.setScene(new Scene(resetSucceedPane, 200, 100));
        resetSucceedVBox.setAlignment(Pos.CENTER);
        backGround.fitWidthProperty().bind(resetStackPane.widthProperty());
        backGround.fitHeightProperty().bind(resetStackPane.heightProperty());
        resetStackPane.getChildren().addAll(resetPane);
        Button submitWarningButton = new Button("??????");
        Button resetButton = new Button("??????");
        warningLabel.setText("????????????????????????");
        warningPane.setTop(warningLabel);
        warningPane.setCenter(warningTextField);
        HBox warningHBox = new HBox();
        warningHBox.setSpacing(20);
        warningHBox.getChildren().addAll(submitWarningButton, cancelWarningButton);
        warningPane.setBottom(warningHBox);
        warningLabel.setStyle("-fx-font-size: 20");
        resetPane.setAlignment(Pos.CENTER_RIGHT);
        BorderPane.setAlignment(warningLabel, Pos.CENTER_LEFT);
        BorderPane.setAlignment(warningTextField, Pos.CENTER_LEFT);
        BorderPane.setAlignment(submitWarningButton, Pos.CENTER_LEFT);
        submitWarningButton.setStyle("-fx-font-size: 20");
        cancelWarningButton.setStyle("-fx-font-size: 20");
        warningPane.setPadding(new Insets(20));
        warningStage.setScene(new Scene(warningPane, 200, 200));
        warningStage.setResizable(false);
        resetStage.setResizable(false);
        Label giveQuestionLabel1 = new Label("??????????????????");
        Label giveQuestionLabel2 = new Label("??????????????????");
        Label receiveAnswerLabel1 = new Label("?????????");
        Label receiveAnswerLabel2 = new Label("?????????");
        Label resetConfirmPasswordLabel = new Label("???????????????");
        TextField receiveAnswer1 = new TextField();
        TextField receiveAnswer2 = new TextField();
        PasswordField resetPasswordField = new PasswordField();
        PasswordField resetConfirmPasswordField = new PasswordField();
        resetPane.add(giveQuestionLabel1, 0, 0);
        resetPane.add(receiveAnswerLabel1, 0, 1);
        resetPane.add(receiveAnswer1, 1, 1);
        resetPane.add(giveQuestionLabel2, 0, 2);
        resetPane.add(receiveAnswerLabel2, 0, 3);
        resetPane.add(receiveAnswer2, 1, 3);
        resetPane.add(newPasswordLabel, 0, 4);
        resetPane.add(resetPasswordField, 1, 4);
        resetPane.add(resetConfirmPasswordLabel, 0, 5);
        resetPane.add(resetConfirmPasswordField, 1, 5);
        resetPane.add(resetButton, 0, 6);
        resetButton.setStyle("-fx-font-size: 20;-fx-font-weight: bold");
        cancelResetButton.setStyle("-fx-font-size: 20");
        GridPane.setHalignment(giveQuestionLabel1, HPos.RIGHT);
        GridPane.setHalignment(giveQuestionLabel2, HPos.RIGHT);
        GridPane.setHalignment(receiveAnswerLabel1, HPos.RIGHT);
        GridPane.setHalignment(receiveAnswerLabel2, HPos.RIGHT);
        GridPane.setHalignment(newPasswordLabel, HPos.RIGHT);
        GridPane.setHalignment(resetConfirmPasswordLabel, HPos.RIGHT);
        GridPane.setHalignment(cancelResetButton, HPos.RIGHT);
        GridPane.setHalignment(resetButton, HPos.RIGHT);
        resetPane.add(cancelResetButton, 1, 6);
        resetPane.setAlignment(Pos.CENTER);
        resetPane.setHgap(10);
        resetPane.setVgap(10);
        resetPane.setPadding(new Insets(10, 10, 10, 10));
        resetStage.setScene(new Scene(resetStackPane, 300, 400));
        resetStage.setResizable(false);
        warningStage.show();
        submitWarningButton.setOnAction(actionEvent -> {
            boolean flag = false;
            receiveAnswerLabel1.setTextFill(Color.BLACK);
            receiveAnswerLabel1.setText("?????????");
            receiveAnswerLabel2.setTextFill(Color.BLACK);
            receiveAnswerLabel2.setText("?????????");
            resetConfirmPasswordLabel.setTextFill(Color.BLACK);
            resetConfirmPasswordLabel.setText("???????????????");
            receiveAnswer1.clear();
            receiveAnswer2.clear();
            resetConfirmPasswordField.clear();
            for (int i = 0; i < userNumber.get(); i++) {
                if (users.get(i).getAccount().equals(warningTextField.getText())) {
                    flag = true;
                    nowUser.set(i);
                    break;
                }
            }
            if (flag) {
                giveQuestionLabel1.setText("??????????????????" + users.get(nowUser.get()).getSecurityQuestion1());
                giveQuestionLabel2.setText("??????????????????" + users.get(nowUser.get()).getSecurityQuestion2());
                ans1.set(users.get(nowUser.get()).getSecurityAnswer1());
                ans2.set(users.get(nowUser.get()).getSecurityAnswer2());
                warningStage.close();
                resetStage.show();
            } else {
                warningLabel.setText("?????????????????????");
                warningLabel.setTextFill(Color.RED);
                warningTextField.clear();
            }
        });
        cancelWarningButton.setOnAction(actionEvent -> {
            warningLabel.setText("????????????????????????");
            warningLabel.setTextFill(Color.BLACK);
            warningStage.close();
        });
        cancelResetButton.setOnAction(actionEvent1 -> resetStage.close());
        resetButton.setOnAction(actionEvent -> {
            if (resetPasswordField.getText().equals(resetConfirmPasswordField.getText()) && ans1.get().equals(receiveAnswer1.getText()) && ans2.get().equals(receiveAnswer2.getText())) {
                users.get(nowUser.get()).setPassword(resetPasswordField.getText());
                try {
                    PrintWriter outputFile = new PrintWriter(informationUsersFile);
                    for (int i = 0; i < userNumber.get(); i++) {
                        outputFile.print(users.get(i).getId() + " " + users.get(i).getAccount() + " " + users.get(i).getPassword() + " " + users.get(i).getSecurityQuestion1() + " " + users.get(i).getSecurityAnswer1() + " " + users.get(i).getSecurityQuestion2() + " " + users.get(i).getSecurityAnswer2() + " " + users.get(i).getScore() + "\n");
                    }
                    outputFile.close();
                    resetSucceedStage.show();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!ans1.get().equals(receiveAnswer1.getText())) {
                receiveAnswerLabel1.setTextFill(Color.RED);
                receiveAnswerLabel1.setText("???????????????");
            } else {
                receiveAnswerLabel1.setTextFill(Color.BLACK);
                receiveAnswerLabel1.setText("?????????");
            }
            if (!ans2.get().equals(receiveAnswer2.getText())) {
                receiveAnswerLabel2.setTextFill(Color.RED);
                receiveAnswerLabel2.setText("???????????????");
            } else {
                receiveAnswerLabel2.setTextFill(Color.BLACK);
                receiveAnswerLabel2.setText("?????????");
            }
            if (!resetPasswordField.getText().equals(resetConfirmPasswordField.getText())) {
                resetConfirmPasswordLabel.setTextFill(Color.RED);
                resetConfirmPasswordLabel.setText("?????????????????????");
            } else {
                resetConfirmPasswordLabel.setTextFill(Color.BLACK);
                resetConfirmPasswordLabel.setText("???????????????");
            }
        });
        resetSucceedButton.setOnAction(actionEvent -> {
            resetSucceedStage.close();
            resetStage.close();
        });
        warningStage.getIcons().addAll(icon);
        resetStage.getIcons().addAll(icon);
        resetSucceedStage.getIcons().addAll(icon);
        warningStage.setTitle("????????????");
        resetStage.setTitle("????????????");
        resetSucceedStage.setTitle("??????????????????");
        warningStage.setResizable(false);
        resetStage.setResizable(false);
        resetSucceedStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
