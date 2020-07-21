
package com.example.proyectomovil.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NOTARESPONSE implements Serializable, Parcelable
{

    @SerializedName("ObjNOTA")
    @Expose
    private ObjNOTA objNOTA;
    @SerializedName("ObjListaNOTA")
    @Expose
    private List<ObjListaNOTum> objListaNOTA = new ArrayList<ObjListaNOTum>();
    public final static Creator<NOTARESPONSE> CREATOR = new Creator<NOTARESPONSE>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NOTARESPONSE createFromParcel(Parcel in) {
            return new NOTARESPONSE(in);
        }

        public NOTARESPONSE[] newArray(int size) {
            return (new NOTARESPONSE[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5813893641418155386L;

    protected NOTARESPONSE(Parcel in) {
        this.objNOTA = ((ObjNOTA) in.readValue((ObjNOTA.class.getClassLoader())));
        in.readList(this.objListaNOTA, (com.example.proyectomovil.pojo.ObjListaNOTum.class.getClassLoader()));
    }

    public NOTARESPONSE() {
    }

    public ObjNOTA getObjNOTA() {
        return objNOTA;
    }

    public void setObjNOTA(ObjNOTA objNOTA) {
        this.objNOTA = objNOTA;
    }

    public List<ObjListaNOTum> getObjListaNOTA() {
        return objListaNOTA;
    }

    public void setObjListaNOTA(List<ObjListaNOTum> objListaNOTA) {
        this.objListaNOTA = objListaNOTA;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(objNOTA);
        dest.writeList(objListaNOTA);
    }

    public int describeContents() {
        return  0;
    }

}
