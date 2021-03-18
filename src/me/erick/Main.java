package me.erick;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Main extends JPanel {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, NativeHookException {
	Controls controls = new Controls();
	GlobalScreen.registerNativeHook();
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			System.exit(-1);
		}
	GlobalScreen.addNativeKeyListener(controls);

    }
}
