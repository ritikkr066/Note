// Step 4: Invoker

public class RemoteControl {

      private Command lastCommand;

    public void press(Command command) {
        command.execute();
       lastCommand = command;
    }

    public void undo() {
        if(lastCommand != null) {
            lastCommand.undo();
        }
    }

}
