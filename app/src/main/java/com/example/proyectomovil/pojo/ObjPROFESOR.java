
package com.example.proyectomovil.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjPROFESOR implements Serializable, Parcelable
{

    @SerializedName("IdDocente")
    @Expose
    private Integer idDocente;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Apellido")
    @Expose
    private String apellido;
    @SerializedName("Usuario")
    @Expose
    private String usuario;
    @SerializedName("Clave")
    @Expose
    private String clave;
    @SerializedName("IdCurso")
    @Expose
    private Integer idCurso;
    @SerializedName("IdUsuario")
    @Expose
    private Integer idUsuario;
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
    public final static Parcelable.Creator<ObjPROFESOR> CREATOR = new Creator<ObjPROFESOR>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ObjPROFESOR createFromParcel(Parcel in) {
            return new ObjPROFESOR(in);
        }

        public ObjPROFESOR[] newArray(int size) {
            return (new ObjPROFESOR[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5572011386580877427L;

    protected ObjPROFESOR(Parcel in) {
        this.idDocente = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nombre = ((String) in.readValue((String.class.getClassLoader())));
        this.apellido = ((String) in.readValue((String.class.getClassLoader())));
        this.usuario = ((String) in.readValue((String.class.getClassLoader())));
        this.clave = ((String) in.readValue((String.class.getClassLoader())));
        this.idCurso = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.idUsuario = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.eliminado = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.codigoError = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.descripcionError = ((String) in.readValue((String.class.getClassLoader())));
        this.mensajeError = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public ObjPROFESOR() {
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
        dest.writeValue(idDocente);
        dest.writeValue(nombre);
        dest.writeValue(apellido);
        dest.writeValue(usuario);
        dest.writeValue(clave);
        dest.writeValue(idCurso);
        dest.writeValue(idUsuario);
        dest.writeValue(eliminado);
        dest.writeValue(codigoError);
        dest.writeValue(descripcionError);
        dest.writeValue(mensajeError);
    }

    public int describeContents() {
        return 0;
    }

}
