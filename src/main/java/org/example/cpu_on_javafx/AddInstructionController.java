package org.example.cpu_on_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static org.example.cpu_on_javafx.CPU.Memory;
import static org.example.cpu_on_javafx.MainController.indexForRun;


public class AddInstructionController {

    Program prog = BProgram.build();
    GridPane allView;

    public AddInstructionController(GridPane allView) {
        this.allView = allView;

    }

    @FXML
    TextField arg1, arg2, arg3;

    @FXML
    void addInstruction(){

        prog.add(
                new Command(
                        arg1.getText(),
                        arg2.getText(),
                        arg3.getText())
                );

        prog.updateViewInstruction(allView, indexForRun);

    }

}
