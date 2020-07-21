
package com.example.proyectomovil.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjListaNOTum implements Serializable, Parcelable
{

    @SerializedName("IdNota")
    @Expose
    private Integer idNota;
    @SerializedName("Nota1")
    @Expose
    private Integer nota1;
    @SerializedName("Nota2")
    @Expose
    private Integer nota2;
    @SerializedName("Nota3")
    @Expose
    private Integer nota3;
    @SerializedName("Nota4")
    @Expose
    private Integer nota4;
    @SerializedName("Nota5")
    @Expose
    private Integer nota5;
    @SerializedName("Promedio")
    @Expose
    private Integer promedio;
    @SerializedName("IdEstudiante")
    @Expose
    private Integer idEstudiante;
    @SerializedName("Curso")
    @Expose
    private String curso;
    @SerializedName("IdCurso")
    @Expose
    private Integer idCurso;
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
    public final static Creator<ObjListaNOTum> CREATOR = new Creator<ObjListaNOTum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ObjListaNOTum createFromParcel(Parcel in) {
            return new ObjListaNOTum(in);
        }

        public ObjListaNOTum[] newArray(int size) {
            return (new ObjListaNOTum[size]);
        }

    }
    ;
    private final static long serialVersionUID = -607117435371842495L;

    protected ObjListaNOTum(Parcel in) {
        this.idNota = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nota1 = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nota2 = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nota3 = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nota4 = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nota5 = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.promedio = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.idEstudiante = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.curso = ((String) in.readValue((String.class.getClassLoader())));
        this.idCurso = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.eliminado = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.codigoError = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.descripcionError = ((String) in.readValue((String.class.getClassLoader())));
        this.mensajeError = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public ObjListaNOTum() {
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Integer getNota1() {
        return nota1;
    }

    public void setNota1(Integer nota1) {
        this.nota1 = nota1;
    }

    public Integer getNota2() {
        return nota2;
    }

    public void setNota2(Integer nota2) {
        this.nota2 = nota2;
    }

    public Integer getNota3() {
        return nota3;
    }

    public void setNota3(Integer nota3) {
        this.nota3 = nota3;
    }

    public Integer getNota4() {
        return nota4;
    }

    public void setNota4(Integer nota4) {
        this.nota4 = nota4;
    }

    public Integer getNota5() {
        return nota5;
    }

    public void setNota5(Integer nota5) {
        this.nota5 = nota5;
    }

    public Integer getPromedio() {
        return promedio;
    }

    public void setPromedio(Integer promedio) {
        this.promedio = promedio;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
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
        dest.writeValue(idNota);
        dest.writeValue(nota1);
        dest.writeValue(nota2);
        dest.writeValue(nota3);
        dest.writeValue(nota4);
        dest.writeValue(nota5);
        dest.writeValue(promedio);
        dest.writeValue(idEstudiante);
        dest.writeValue(curso);
        dest.writeValue(idCurso);
        dest.writeValue(eliminado);
        dest.writeValue(codigoError);
        dest.writeValue(descripcionError);
        dest.writeValue(mensajeError);
    }

    public int describeContents() {
        return  0;
    }

}
