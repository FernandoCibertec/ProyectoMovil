
package com.example.proyectomovil.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ESTUDIANTERESPONSE implements Serializable, Parcelable
{

    @SerializedName("ObjESTUDIANTE")
    @Expose
    private ObjESTUDIANTE objESTUDIANTE;
    @SerializedName("ObjListaESTUDIANTE")
    @Expose
    private List<ObjListaESTUDIANTE> objListaESTUDIANTE = new ArrayList<ObjListaESTUDIANTE>();
    public final static Creator<ESTUDIANTERESPONSE> CREATOR = new Creator<ESTUDIANTERESPONSE>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ESTUDIANTERESPONSE createFromParcel(Parcel in) {
            return new ESTUDIANTERESPONSE(in);
        }

        public ESTUDIANTERESPONSE[] newArray(int size) {
            return (new ESTUDIANTERESPONSE[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7867847050575622900L;

    protected ESTUDIANTERESPONSE(Parcel in) {
        this.objESTUDIANTE = ((ObjESTUDIANTE) in.readValue((ObjESTUDIANTE.class.getClassLoader())));
        in.readList(this.objListaESTUDIANTE, (com.example.proyectomovil.pojo.ObjListaESTUDIANTE.class.getClassLoader()));
    }

    public ESTUDIANTERESPONSE() {
    }

    public ObjESTUDIANTE getObjESTUDIANTE() {
        return objESTUDIANTE;
    }

    public void setObjESTUDIANTE(ObjESTUDIANTE objESTUDIANTE) {
        this.objESTUDIANTE = objESTUDIANTE;
    }

    public List<ObjListaESTUDIANTE> getObjListaESTUDIANTE() {
        return objListaESTUDIANTE;
    }

    public void setObjListaESTUDIANTE(List<ObjListaESTUDIANTE> objListaESTUDIANTE) {
        this.objListaESTUDIANTE = objListaESTUDIANTE;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(objESTUDIANTE);
        dest.writeList(objListaESTUDIANTE);
    }

    public int describeContents() {
        return  0;
    }

}
