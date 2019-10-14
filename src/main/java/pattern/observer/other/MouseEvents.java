package pattern.observer.other;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by 11981 on 2019/10/13.
 */
public class MouseEvents {
    private Frame frame;

    private Button button;

    MouseEvents(){

        frame = new Frame("点击按钮触发点击事件，控制台将打印日志");
        frame.setBounds(300, 200, 600, 300);
        frame.setLayout(new FlowLayout());

        button = new Button("this is a button");
        button.setFont(new Font("Default", 0, 30));
        frame.add(button);

        dealWithEvent();
        frame.setVisible(true);

    }

    private void dealWithEvent(){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        button.addActionListener(new ActionListener() {

            private int eventCount = 1;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(String.format("动作发生 %d 次", eventCount++));
            }
        });
    }

    public static void main(String[] args) {
        new MouseEvents();
    }

}
