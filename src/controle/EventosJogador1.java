package src.controle;

import javax.swing.ImageIcon;

import src.visao.Jogador;

public class EventosJogador1 {
    public static void eventosJogador1(int opc){
        if (opc == 1){
            ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x + 5, 
                                                    ControleFrame.getPlayUm().getLocation().y);
            if(ControleFrame.getPlayUm().getSprit_andar_control() < 9)
            {
                ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
                ControleFrame.getPlayUm().setSprit_andar_control(ControleFrame.getPlayUm().getSprit_andar_control() + 1);
            }else
            {

                ControleFrame.getPlayUm().setSprit_andar_control(0);
                ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
                
            }
        }
        else if (opc == 2){
            ControleFrame.getPlayUm().setLocation( ControleFrame.getPlayUm().getLocation().x - 5,  ControleFrame.getPlayUm().getLocation().y);
            if(ControleFrame.getPlayUm().getSprit_andar_control() > 0)
            {
                ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
                ControleFrame.getPlayUm().setSprit_andar_control(ControleFrame.getPlayUm().getSprit_andar_control() - 1);
            }else
            {

                ControleFrame.getPlayUm().setSprit_andar_control(9);
                ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
                
            }
        }
        else if (opc == 3){
            ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x, ControleFrame.getPlayUm().getLocation().y + 5);
        }
        else if (opc == 4){
            float vlc = 0;

            ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getPularSprite()));
		
            for (int i = 0 ; i < 15; i++) {
                try {
                    vlc += -(10 * 0.0333333333333);
                    ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x, 
                                                        Math.round(ControleFrame.getPlayUm().getY() + vlc));
                    Thread.sleep(10);
                } catch (InterruptedException e1) {

                    e1.printStackTrace();
                }
            }
            ControleFrame.getPlayUm().setSprit_andar_control(0);
            ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
        }
        else if (opc == 5){
            float vlc = 0;
            for (int i = 0 ; i < 3; i++) {
                try {
                    vlc += -(10 * 0.0333333333333);
                    ControleFrame.getPlayUm().setSprit_soco_controll(i);
                    ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getSocarSprites()
                                                      [ControleFrame.getPlayUm().getSprit_andar_control()]));
                    ControleFrame.getPlayUm().setLocation(Math.round(ControleFrame.getPlayUm().getX() + vlc), 
                                                        ControleFrame.getPlayUm().getY());
                    Thread.sleep(10);
                } catch (InterruptedException e1) {

                    e1.printStackTrace();
                }
            }
            soco(ControleFrame.getJogador2());
            ControleFrame.getPlayUm().setSprit_andar_control(0);
            ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
        }
        else if (opc == 6){
            float vlc = 0;
            for (int i = 0 ; i < 3; i++) {
                try {
                    vlc += -(10 * 0.0333333333333);
                    ControleFrame.getPlayUm().setSprit_chute_control(i);
                    ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getSocarSprites()
                                                      [ControleFrame.getPlayUm().getSprit_chute_control()]));
                    ControleFrame.getPlayUm().setLocation(Math.round(ControleFrame.getPlayUm().getX() + vlc), 
                                                        ControleFrame.getPlayUm().getY());
                    Thread.sleep(10);
                } catch (InterruptedException e1) {

                    e1.printStackTrace();
                }
            }
            ControleFrame.getPlayUm().setSprit_andar_control(0);
            ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
            chute(ControleFrame.getJogador2());
        }
        ControleFrame.setAcao1();
    }

    public static void soco(Runnable jogador){
        jogador.run();
        try {
            jogador.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ControleFrame.getPlayUm().getX() == ControleFrame.getPlayDois().getX()){
            System.out.println("HIT");
        }
        jogador.notify();
    }

    public static void chute(Runnable jogador){
        jogador.run();
        try {
            jogador.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ControleFrame.getPlayUm().getX() == ControleFrame.getPlayDois().getX()){
            System.out.println("HIT");
        }
        jogador.notify();
    }
}