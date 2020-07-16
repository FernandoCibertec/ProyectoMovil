
package com.example.proyectomovil.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjListaESTUDIANTE implements Serializable, Parcelable
{

    @SerializedName("IdEstudiante")
    @Expose
    private Integer idEstudiante;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Apellido")
    @Expose
    private String apellido;
    @SerializedName("Dni")
    @Expose
    private String dni;
    @SerializedName("IdGrado")
    @Expose
    private Integer idGrado;
    @SerializedName("CodEstado")
    @Expose
    private String codEstado;
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
    public final static Creator<ObjListaESTUDIANTE> CREATOR = new Creator<ObjListaESTUDIANTE>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ObjListaESTUDIANTE createFromParcel(Parcel in) {
            return new ObjListaESTUDIANTE(in);
        }

        public ObjListaESTUDIANTE[] newArray(int size) {
            return (new ObjListaESTUDIANTE[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5305124395390357185L;

    protected ObjListaESTUDIANTE(Parcel in) {
        this.idEstudiante = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nombre = ((String) in.readValue((String.class.getClassLoader())));
        this.apellido = ((String) in.readValue((String.class.getClassLoader())));
        this.dni = ((String) in.readValue((String.class.getClassLoader())));
        this.idGrado = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.codEstado = ((String) in.readValue((String.class.getClassLoader())));
        this.idUsuario = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.eliminado = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.codigoError = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.descripcionError = ((String) in.readValue((String.class.getClassLoader())));
        this.mensajeError = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public ObjListaESTUDIANTE() {
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
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
        dest.writeValue(idEstudiante);
        dest.writeValue(nombre);
        dest.writeValue(apellido);
        dest.writeValue(dni);
        dest.writeValue(idGrado);
        dest.writeValue(codEstado);
        dest.writeValue(idUsuario);
        dest.writeValue(eliminado);
        dest.writeValue(codigoError);
        dest.writeValue(descripcionError);
        dest.writeValue(mensajeError);
    }

    public int describeContents() {
        return  0;
    }

}
