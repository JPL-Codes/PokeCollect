package org.pokecollect.service;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Random;
public class PokeFrame extends JFrame{



        JPanel mainPnl;
        JPanel topPnl;
        JPanel centerPnl;
        JPanel bottomPnl;
        JButton quitBtn;
        Icon pikaIcon;
        JLabel titleLbl;
        JLabel fontLbl;
        JLabel secLbl;
        JTextField searchField;
        JButton searchButton;


        public PokeFrame()
        {

            CreateGUI();
            setTitle("PokeCollect");
            //  setSize(600,800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenHeight = screenSize.height;
            int screenWidth = screenSize.width;
            // center frame in screen
            setSize(3 * screenWidth / 4, 3 * screenHeight / 4);
            setLocation(screenWidth / 8, screenHeight / 6);
            setVisible(true);
        }

        private void CreateGUI()
        {

            mainPnl = new JPanel();
            topPnl = new JPanel();
            centerPnl = new JPanel();
            bottomPnl = new JPanel();


            mainPnl.setLayout(new BorderLayout());
            mainPnl.add(topPnl, BorderLayout.NORTH);
            mainPnl.add(centerPnl, BorderLayout.CENTER);
            mainPnl.add(bottomPnl, BorderLayout.SOUTH);

            add(mainPnl);
            createTopPnl();
            createCenterPnl();
            createBottomPnl();

        }

        private void createCenterPnl()
        {
            JTextField searchField = new JTextField(20);
            JButton searchButton = new JButton("Search");
            centerPnl.setLayout(new FlowLayout());
            searchField.setHorizontalAlignment(JTextField.LEFT);
            searchButton.setHorizontalTextPosition(JButton.RIGHT);
            centerPnl.add(searchField);
            centerPnl.add(searchButton);

        }

        private void createTopPnl()
        {
            pikaIcon = new ImageIcon("src/main/resources/pikaThumb3.jpg");
            titleLbl = new JLabel("",pikaIcon, JLabel.CENTER);
            secLbl = new JLabel(" \n \n Enter Pokemon name, move, or type:");
            titleLbl.setVerticalTextPosition(JLabel.TOP);
            secLbl.setVerticalTextPosition(JLabel.BOTTOM);
            secLbl.setFont(new Font("Comic Sans MS",Font.PLAIN,12));
            titleLbl.setFont(new Font("Century", Font.PLAIN, 36));
            titleLbl.setHorizontalTextPosition(JLabel.CENTER);
            topPnl.add(titleLbl);
            topPnl.add(secLbl);


        }

        private void createBottomPnl()
        {





            quitBtn = new JButton("Quit");
            quitBtn.addActionListener((ActionEvent ae) ->
                    System.exit(0));

            bottomPnl.setLayout(new GridLayout(1,1));

            bottomPnl.add(quitBtn);
        }
    }

