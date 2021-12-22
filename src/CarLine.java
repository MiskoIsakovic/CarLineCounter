public class CarLine {
    int arrivalTime;
    int departureTime;

    public CarLine(int arrivalTime){
        this.arrivalTime=arrivalTime;
        this.departureTime=0;
    }
    public void setArrivalTime(int arrivalTime){
        this.arrivalTime=arrivalTime;
    }
    public void setDepartureTime(int departureTime){
        this.departureTime=departureTime;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getDepartureTime(){
        return departureTime;
    }
    public int totalTime(){
        return departureTime-arrivalTime;
    }
}
