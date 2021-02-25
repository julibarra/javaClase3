import java.util.Date;

public class Timer {
    private long start;
    private long end;


    public void start(){
        this.start= new Date().getTime();
    }
    public void stop(){
        this.end=new Date().getTime();
    }
    public long getElapsedTime(){
        return this.end-this.start;
    }

}
