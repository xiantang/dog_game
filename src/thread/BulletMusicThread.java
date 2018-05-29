package thread;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.DataLine.Info;

public class BulletMusicThread extends Thread{

    private String filename;

    private AudioFormat audioFormat;

    private byte[] samples;

    public BulletMusicThread(String filename)
    {
        this.filename=filename;

        reverseMusic();
    }

    public  void reverseMusic()
    {
        try {

            AudioInputStream stream= AudioSystem.getAudioInputStream(new File(filename));

            audioFormat= stream.getFormat();

            samples=getSamples(stream);


        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public byte[] getSamples(AudioInputStream stream)
    {
        int size=   (int) (stream.getFrameLength()*audioFormat.getFrameSize());

        byte[] samples=new byte[size];

        DataInputStream dataInputStream=new DataInputStream(stream);

        try {
            dataInputStream.readFully(samples);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return samples;
    }

    public void play(InputStream source)
    {
        int size=(int) (audioFormat.getFrameSize()*audioFormat.getSampleRate());

        byte[] buffer=new byte[size];

        SourceDataLine dataLine=null;

        Info info=new Info(SourceDataLine.class,audioFormat);

        try {
            dataLine=(SourceDataLine) AudioSystem.getLine(info);

            dataLine.open(audioFormat,size);
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        dataLine.start();

        try {
            int numBytesRead = 0;
            while (numBytesRead != -1) {

                numBytesRead =
                        source.read(buffer, 0, buffer.length);
                if (numBytesRead != -1) {
                    dataLine.write(buffer, 0, numBytesRead);
                }
            }

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        dataLine.drain();
        dataLine.close();

    }
    public void run(){
//        添加背景音乐的线程 控制循环一次的时间

        try {
            InputStream stream =new ByteArrayInputStream(samples);

            play(stream);

            Thread.currentThread().sleep(540000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}