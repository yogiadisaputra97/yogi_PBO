package warnet;

public class Main {

    public static void main(String[] args) {
        ViewAkun viewAkun = new ViewAkun();
        ModelAkun modelAkun = new ModelAkun();
        ControllerAkun controllerAkun = new ControllerAkun(viewAkun, modelAkun);
    }
    
}
