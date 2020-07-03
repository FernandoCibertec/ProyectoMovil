
package com.example.proyectomovil.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROFESORRESPONSE implements Serializable, Parcelable
{

    @SerializedName("ObjPROFESOR")
    @Expose
    private ObjPROFESOR objPROFESOR;
    @SerializedName("ObjListaPROVEEDOR")
    @Expose
    private List<ObjListaPROFESOR> objListaPROFESOR = new ArrayList<ObjListaPROFESOR>();
    public final static Creator<PROFESORRESPONSE> CREATOR = new Creator<PROFESORRESPONSE>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PROFESORRESPONSE createFromParcel(Parcel in) {
            return new PROFESORRESPONSE(in);
        }

        public PROFESORRESPONSE[] newArray(int size) {
            return (new PROFESORRESPONSE[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4987775956370307563L;

    protected PROFESORRESPONSE(Parcel in) {
        this.objPROFESOR = ((ObjPROFESOR) in.readValue((ObjPROFESOR.class.getClassLoader())));
        in.readList(this.objListaPROFESOR, (ObjListaPROFESOR.class.getClassLoader()));
    }

    public PROFESORRESPONSE() {
    }

    public ObjPROFESOR getObjPROFESOR() {
        return objPROFESOR;
    }

    public void setObjPROFESOR(ObjPROFESOR objPROFESOR) {
        this.objPROFESOR = objPROFESOR;
    }

    public List<ObjListaPROFESOR> getObjListaPROFESOR() {
        return objListaPROFESOR;
    }

    public void setObjListaPROFESOR(List<ObjListaPROFESOR> objListaPROFESOR) {
        this.objListaPROFESOR = objListaPROFESOR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(objPROFESOR);
        dest.writeList(objListaPROFESOR);
    }

    public int describeContents() {
        return  0;
    }

}
