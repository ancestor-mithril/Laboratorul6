package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    //...TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        //...TODO
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("..\\imagine.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    //...TODO

    /**
     * citesc imaginea de la calea respectiva si o incarc in DrawingPanel::image
     * redesenez frame-ul pentru ca nu se actualizeaza singur
     * @param e
     */
    private void load(ActionEvent e){
        try{
            BufferedImage x = ImageIO.read(new File("..\\imagine.png"));
            frame.canvas.image=x;
            frame.canvas.graphics=frame.canvas.image.createGraphics();
            frame.repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * apelez functia de reset si redesenez frame-ul
     * @param e
     */
    private void reset(ActionEvent e){
        frame.canvas.reset();
        frame.repaint();
    }

    /**
     * inchid frame-ul si termin programul
     * @param e
     */
    private void exit(ActionEvent e){
        frame.dispose();
        System.exit(0);
    }
}
