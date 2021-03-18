package me.erick;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Controls implements NativeKeyListener {
    final String localPath = System.getProperty("user.dir")+"\\sounds\\";
    Clip click1, click2, enter, space;

    public Controls() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        AudioInputStream clickOne = AudioSystem.getAudioInputStream(new File(localPath+"click1.wav").getAbsoluteFile());
        AudioInputStream clickTwo = AudioSystem.getAudioInputStream(new File(localPath+"click2.wav").getAbsoluteFile());
        AudioInputStream EnterKey = AudioSystem.getAudioInputStream(new File(localPath+"Enter.wav").getAbsoluteFile());
        AudioInputStream SpaceKey = AudioSystem.getAudioInputStream(new File(localPath+"space.wav").getAbsoluteFile());
        click1 = AudioSystem.getClip();
        click1.open(clickOne);
        click2 = AudioSystem.getClip();
        click2.open(clickTwo);
        enter = AudioSystem.getClip();
        enter.open(EnterKey);
        space = AudioSystem.getClip();
        space.open(SpaceKey);
    }


    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if(e.getKeyCode()==NativeKeyEvent.VC_ENTER){
            enter.setFramePosition(0);
            enter.start();
        } else if(e.getKeyCode()==NativeKeyEvent.VC_SPACE){
            space.setFramePosition(0);
            space.start();
        } else {
            if(click1.isActive()||click2.isActive()){
                click1.stop();
                click2.stop();
            }
            switch ((int)(Math.random()*2)){
                case 0: click1.setFramePosition(0);
                    click1.start();
                    break;
                case 1: click2.setFramePosition(0);
                    click2.start();
                    break;
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }
}
