public class Direct {
    private Point start;
    private Point end;

    public Direct (Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end; // Java автоматически вызывает start.toString() который мы переопределили
    }
    public Point getStart() { return start; }
    public Point getEnd()   { return end; }

    public void setStart(Point start) { this.start = start; }
    public void setEnd(Point end)     { this.end = end; }
}
