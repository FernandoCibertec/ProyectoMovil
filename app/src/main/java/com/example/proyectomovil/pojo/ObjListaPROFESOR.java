
package com.example.proyectomovil.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjListaPROFESOR implements Serializable, Parcelable
{

    @SerializedName("iddocente")
    @Expose
    private Integer iddocente;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("clave")
    @Expose
    private String clave;
    @SerializedName("idcurso")
    @Expose
    private Integer idcurso;
    @SerializedName("Flores")
    @Expose
    private String flores;
    public final static Creator<ObjListaPROFESOR> CREATOR = new Creator<ObjListaPROFESOR>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ObjListaPROFESOR createFromParcel(Parcel in) {
            return new ObjListaPROFESOR(in);
        }

        public ObjListaPROFESOR[] newArray(int size) {
            return (new ObjListaPROFESOR[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1412727880224427596L;

    protected ObjListaPROFESOR(Parcel in) {
        this.iddocente = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nombre = ((String) in.readValue((String.class.getClassLoader())));
        this.apellidos = ((String) in.readValue((String.class.getClassLoader())));
        this.usuario = ((String) in.readValue((String.class.getClassLoader())));
        this.clave = ((String) in.readValue((String.class.getClassLoader())));
        this.idcurso = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.flores = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ObjListaPROFESOR() {
    }

    public Integer getIddocente() {
        return iddocente;
    }

    public void setIddocente(Integer iddocente) {
        this.iddocente = iddocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getFlores() {
        return flores;
    }

    public void setFlores(String flores) {
        this.flores = flores;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(iddocente);
        dest.writeValue(nombre);
        dest.writeValue(apellidos);
        dest.writeValue(usuario);
        dest.writeValue(clave);
        dest.writeValue(idcurso);
        dest.writeValue(flores);
    }

    public int describeContents() {
        return  0;
    }

}
