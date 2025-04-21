package org.example.cpu_on_javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.example.cpu_on_javafx.Command;


import java.io.IOException;
import java.util.*;

import static org.example.cpu_on_javafx.MainController.indexForRun;


public class Program implements Iterable<Command> {
    ArrayList<Command> commands = new ArrayList<>();
    public int runIndex;

@Override
public Iterator<Command> iterator(){
    return new Iterator<Command>() {

        int index;

        @Override
        public boolean hasNext() {
            return index<commands.size();
        }

        @Override
        public Command next() {
            return commands.get(index++);
        }
    };
}
    public void add(Command newCommand){
        commands.add(newCommand);
    }
    public void clear(){
        commands.clear();
    }
    public int size(){
        return commands.size();
    }
    public void delete(Command c){
        commands.remove(c);
    }

    void swap(int index1,int index2){
        Collections.swap(commands,index1,index2);
    }


    void updateViewInstruction(GridPane allView, int indexForRun){
        allView.getChildren().clear();
        int i = 0;
        for(Command c: commands) {
            InstructionViewController ivc = new InstructionViewController(allView);
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("instruction_view.fxml"));
            fxmlLoader.setController(ivc);
            try {
                Pane pane = fxmlLoader.load();
                if(indexForRun == i){
                    ivc.init(c,true);
                }
                else {
                    ivc.init(c,false);
                }

                allView.addColumn(0, pane);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }


    public HashMap<String,Integer> mostPopularInstruction(){
        HashMap<String,Integer> mapPopularInstruction = new HashMap<>();
        String instruction ="mostPopularInstruction: ";
        for(int i= 0;i<indexForRun;i++){
            Command c = commands.get(i);
            int count = mapPopularInstruction.getOrDefault(c.arg1,0);
            mapPopularInstruction.put(c.arg1,++count);
        }
//        for (Command c: commands){
//            int count = mapPopularInstruction.getOrDefault(c.arg1,0);
//            mapPopularInstruction.put(c.arg1,++count);
//
//
//        }
        instruction += Collections.max(mapPopularInstruction.entrySet(),Map.Entry.comparingByValue());
        return mapPopularInstruction;
    }

    public String diapasonAdr(){
//        List<Integer> list = new ArrayList<>();
//        for (Command c: commands){
//            if(c.arg1.equals("init")){
//                list.add(Integer.valueOf(c.arg2));
//            }
//            if(c.arg1.equals("ld") || c.arg1.equals("st")){
//                list.add(Integer.valueOf(c.arg3));
//            }

//        }

        List<Integer> list =commands.stream().filter(c -> c.arg1.equals("init") || c.arg1.equals("ld") || c.arg1.equals("st"))
                .collect(
                        ()->new ArrayList<Integer>(),
                        (list1, c) ->
                        {   if(c.arg1.equals("init"))
                                list1.add(Integer.valueOf(c.arg2));
                            else list1.add(Integer.valueOf(c.arg3));
                        },(l1,l2)->l1.addAll(l2)
                );



        int maxValue = Collections.max(list);
        int minValue = Collections.min(list);
        String result = "["+minValue+", "+maxValue+"]";
        return result;
    }

    public String ListInstructions(){
        HashMap<String,Integer> map = new HashMap<>();
        String instruction ="ListInstructions: ";

        for (Command c: commands){
            int count = map.getOrDefault(c.arg1,0);
            map.put(c.arg1,++count);
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String,Integer> entry : list)
            instruction += entry.getKey()+"-"+entry.getValue()+", " ;

        return instruction;
    }
}
