package org.example.cpu_on_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.example.cpu_on_javafx.CPU.Memory;

public class MainController {
    @FXML
    GridPane allView, memory;

    @FXML
    private Label registerA;
    @FXML
    private Label registerB;
    @FXML
    private Label registerC;
    @FXML
    private Label registerD;

    @FXML
    GridPane popularInstructionPane;
    Program prog = BProgram.build();
    ICpu cpu = BCpu.build();
    Executer exec = new Executer(cpu);

    @FXML
    void clean(){

        prog.clear();
        for(int i = 0; i<Memory.length; i++){
            Memory[i] = 0;
        }
        cpu.getRegisters().put("a","*");
        cpu.getRegisters().put("b","*");
        cpu.getRegisters().put("c","*");
        cpu.getRegisters().put("d","*");
        allView.getChildren().clear();
        updateRegisterValues();
        updateMemoryValues();



    }
    @FXML
    void addInstruction() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("add_new_instruction.fxml"));
        AddInstructionController addInstructionController = new AddInstructionController(allView);
        fxmlLoader.setController(addInstructionController);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Добавление инструкции");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void initialize(){
        updateRegisterValues();
        updateMemoryValues();


    }

    void updateMemoryValues(){
        memory.getChildren().clear();
        for(int i = 0; i< Memory.length;i++){
            Label l = new Label();
            l.setText(i+": "+String.valueOf(Memory[i]));
            if(Memory[i]>0) l.setTextFill(Paint.valueOf("RED"));
            memory.addRow(i, l);
        }
    }
    void updateRegisterValues(){
        registerA.setText("A = "+ cpu.getRegisters().get("a"));
        registerB.setText("B = "+ cpu.getRegisters().get("b"));
        registerC.setText("C = "+ cpu.getRegisters().get("c"));
        registerD.setText("D = "+ cpu.getRegisters().get("d"));

    }

    void updatePopularInstructionPane(HashMap<String,Integer> map){
        popularInstructionPane.getChildren().clear();
        int row = 0;

        ArrayList<HashMap.Entry<String, Integer>> forSort = new ArrayList<>(map.entrySet());

        forSort.sort((n1, n2) -> n2.getValue().compareTo(n1.getValue()));

            for (HashMap.Entry<String, Integer> n : forSort) {

                    Label keyLabel = new Label(n.getKey());
                    Label valueLabel = new Label(String.valueOf(n.getValue()));


                    popularInstructionPane.add(keyLabel, 0, row);
                    popularInstructionPane.add(valueLabel, 1, row);

                    row++;
            }

    }




    static int indexForRun = 0;
    @FXML
    void runNextInstruction(){
        if(prog.size()>indexForRun) {
            cpu.exec(prog.commands.get(indexForRun));
            indexForRun++;
            prog.updateViewInstruction(allView, indexForRun);

            updatePopularInstructionPane(prog.mostPopularInstruction());
            updateMemoryValues();
            updateRegisterValues();
        }

    }




}
