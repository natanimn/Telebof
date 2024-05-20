package et.telebof.types;

import java.io.Serializable;


public class MaskPosition implements Serializable {
    private String point;
    private Float x_shift, y_shift, scale;

    public MaskPosition point(String point){
        this.point = point;
        return this;
    }

    public MaskPosition xShift(float xShift){
        this.x_shift = xShift;
        return this;
    }

    public MaskPosition yShift(float yShift){
        this.y_shift = yShift;
        return this;
    }

    public MaskPosition scale(float scale){
        this.scale= scale;
        return this;
    }

}
