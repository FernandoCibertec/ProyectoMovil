
package com.example.proyectomovil.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CURSORESPONSE implements Serializable, Parcelable
{

    @SerializedName("ObjCURSO")
    @Expose
    private ObjCURSO objCURSO;
    @SerializedName("ObjListaCURSO")
    @Expose
    private List<ObjListaCURSO> objListaCURSO = new ArrayList<ObjListaCURSO>();
    public final static Creator<CURSORESPONSE> CREATOR = new Creator<CURSORESPONSE>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CURSORESPONSE createFromParcel(Parcel in) {
            return new CURSORESPONSE(in);
        }

        public CURSORESPONSE[] newArray(int size) {
            return (new CURSORESPONSE[size]);
        }

    }
    ;
    private final static long serialVersionUID = -137376515275208808L;

    protected CURSORESPONSE(Parcel in) {
        this.objCURSO = ((ObjCURSO) in.readValue((ObjCURSO.class.getClassLoader())));
        in.readList(this.objListaCURSO, (com.example.proyectomovil.pojo.ObjListaCURSO.class.getClassLoader()));
    }

    public CURSORESPONSE() {
    }

    public ObjCURSO getObjCURSO() {
        return objCURSO;
    }

    public void setObjCURSO(ObjCURSO objCURSO) {
        this.objCURSO = objCURSO;
    }

    public List<ObjListaCURSO> getObjListaCURSO() {
        return objListaCURSO;
    }

    public void setObjListaCURSO(List<ObjListaCURSO> objListaCURSO) {
        this.objListaCURSO = objListaCURSO;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(objCURSO);
        dest.writeList(objListaCURSO);
    }

    public int describeContents() {
        return  0;
    }

}
