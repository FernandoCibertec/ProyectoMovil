package com.example.proyectomovil.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UsuarioBE implements Serializable, Parcelable
{

    @SerializedName("idUsuario")
    @Expose
    private Integer idUsuario;
    @SerializedName("nomUsuario")
    @Expose
    private String nomUsuario;
    @SerializedName("passUsuario")
    @Expose
    private String passUsuario;
    @SerializedName("idTipo")
    @Expose
    private Integer idTipo;
    @SerializedName("Eliminado")
    @Expose
    private Boolean eliminado;
    @SerializedName("CodigoError")
    @Expose
    private Integer codigoError;
    @SerializedName("DescripcionError")
    @Expose
    private String descripcionError;
    @SerializedName("MensajeError")
    @Expose
    private Object mensajeError;
    public final static Creator<UsuarioBE> CREATOR = new Creator<UsuarioBE>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UsuarioBE createFromParcel(Parcel in) {
            return new UsuarioBE(in);
        }

        public UsuarioBE[] newArray(int size) {
            return (new UsuarioBE[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5317656441954805378L;

    protected UsuarioBE(Parcel in) {
        this.idUsuario = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nomUsuario = ((String) in.readValue((String.class.getClassLoader())));
        this.passUsuario = ((String) in.readValue((String.class.getClassLoader())));
        this.idTipo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.eliminado = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.codigoError = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.descripcionError = ((String) in.readValue((String.class.getClassLoader())));
        this.mensajeError = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public UsuarioBE() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Integer getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public Object getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(Object mensajeError) {
        this.mensajeError = mensajeError;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idUsuario);
        dest.writeValue(nomUsuario);
        dest.writeValue(passUsuario);
        dest.writeValue(idTipo);
        dest.writeValue(eliminado);
        dest.writeValue(codigoError);
        dest.writeValue(descripcionError);
        dest.writeValue(mensajeError);
    }

    public int describeContents() {
        return  0;
    }

}
