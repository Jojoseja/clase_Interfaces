package trabajoInterfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Implementa la interfaz calculadora, que se encargará de hacer las operaciones con String
public class GUILauncher implements Calculadora {
    public static void main(String[] args) {
        //Objeto de la Clase GUILauncher
        GUILauncher window = new GUILauncher();
        //Iniciamos la interfaz
        window.starter();
    }

    //Atributo JFrame para Crear la interfaz, la cual se modifica en el constructor
    private final JFrame window;

    //Atributos String para hacer las operaciones
    String inputS= "";
    String num1 = "";
    String num2 = "";
    String func = "";

    //Atributo JTextField que nos permite mostrar texto en la interfaz
    JTextField display = new JTextField();
    JTextField num1Display = new JTextField();

    //Constructor de la interfaz
    public GUILauncher() {
        //Genera el Objeto JFrame, de nombre window
        window = new JFrame();

        //Titulo de la Ventana
        window.setTitle("Calculadora");

        //Permite cerrar la ventana JFrame cuando se detiene el programa
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tamaño de la Ventana (en px)
        window.setSize(800, 600);

        //Al usar null la ventana aparece en el centro de la pantalla
        window.setLocationRelativeTo(null);
    }

    //Este metodo agrega el "Display" de la calculadora, los Botones y ademas permite que se vea
    public void starter(){
        show();
        buttonStarter();
        functionButtons();
        display();
        num1Display();
    }

    //Permite ver la ventana
    public void show(){
        window.setVisible(true);
    }

    //Botones Numéricos con su número y posición correspondiente
    public void buttonStarter(){
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");
        button1.setBounds(0,100,50,50);
        button2.setBounds(50,100,50,50);
        button3.setBounds(100,100,50,50);
        button4.setBounds(0,50,50,50);
        button5.setBounds(50,50,50,50);
        button6.setBounds(100,50,50,50);
        button7.setBounds(0,0,50,50);
        button8.setBounds(50,0,50,50);
        button9.setBounds(100,0,50,50);
        button0.setBounds(0,150,100,50);
        window.add(button1);
        window.add(button2);
        window.add(button3);
        window.add(button4);
        window.add(button5);
        window.add(button6);
        window.add(button7);
        window.add(button8);
        window.add(button9);
        window.add(button0);

        //Cada botón agrega al String inputS el número correspondiente
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "0";
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "1";
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "2";
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "3";
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "4";
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "5";
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "6";
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "7";
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "8";
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputS += "9";
            }
        });

    }

    //Botones Funcion, al usarlos (menos el botón "="), el String inputS queda registrado como num1,
    //Se guarda la función del botón que se ha usado (el operador) y se vuelve a registrar el numero como inputS,
    //Al usar "=" inputS pasará a ser num2, se muestra el resultado en Display y se registra el resultado como num1
    public void functionButtons(){
        JButton resultButton = new JButton("=");
        resultButton.setBounds(100,150,50,50);
        window.add(resultButton);
        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = inputS;
                display.setText(Calculadora.operar(func, num1, num2));
                num1 = Calculadora.operar(func, num1, num2);
                func = "";
                num2 = "";
            }
        });
        JButton addButton = new JButton("+");
        addButton.setBounds(150,0,50,50);
        window.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numCheck(inputS);
                inputS="";
                func="+";
            }
        });
        JButton subButton = new JButton("-");
        subButton.setBounds(150,50,50,50);
        window.add(subButton);
        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numCheck(inputS);
                inputS="";
                func="-";
            }
        });
        JButton mulButton = new JButton("*");
        mulButton.setBounds(150,100,50,50);
        window.add(mulButton);
        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numCheck(inputS);
                inputS="";
                func="*";
            }
        });
        JButton divButton = new JButton("/");
        divButton.setBounds(150,150,50,50);
        window.add(divButton);
        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numCheck(inputS);
                inputS="";
                func="/";
            }
        });
    }

    //Modificar los Atributos JTextField de la interfaz, display corresponde con el resultado de la operación
    public void display(){
        display.setBounds(0,200,100,50);
        display.setEditable(false);
        window.add(display);
    }
    public void num1Display(){
        num1Display.setBounds(0,250,100,50);
        num1Display.setEditable(false);
        window.add(num1Display);
    }

    //Muestra el texto en el recuadro: Display
    public void modDisplay(String variable){
        display.setText(variable);
    }

    //Permite usar num1 si está vacío y si no lo está usa num2 para hacer la operación
    public void numCheck(String numC){
        modDisplay(numC);
        if (num1.isEmpty()){
            num1 = numC;
            num1Display.setText(numC);
        } else if (num2.isEmpty()){
            num2 = numC;
        }

    }
}