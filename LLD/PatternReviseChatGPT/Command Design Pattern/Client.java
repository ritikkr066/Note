public class Client {
    public static void main(String[] args) {

        Light livingRoomLight = new Light(); //light of the room
        Fan livingRoomFan = new Fan();
        AC livingRoomAC = new AC();

        // specific button configured to turn ON the living room light
        Command lightON = new LightOnCommand(livingRoomLight);
        Command lightOFF = new LightOffCommand(livingRoomLight);
        Command fanON = new FanOnCommand(livingRoomFan);
        Command acON = new ACOnCommand(livingRoomAC); 


        // The remote control
        // It does NOT know about lights, fans, ACs
        RemoteControl remote = new RemoteControl();

        remote.press(lightON);
        remote.press(lightOFF);
        remote.press(acON);
        remote.press(fanON);
        remote.undo();
        remote.undo();
        remote.undo();

    }
}
