package com.trackx.truelocate.testreport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reporter-output">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="suite" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="groups">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="group" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="method" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                               &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="test" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="class" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="test-method" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                                                 &lt;element name="params">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="value">
 *                                                                       &lt;complexType>
 *                                                                         &lt;simpleContent>
 *                                                                           &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                                                             &lt;attribute name="is-null" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                                           &lt;/extension>
 *                                                                         &lt;/simpleContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                   &lt;/sequence>
 *                                                                   &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="exception">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="full-stacktrace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="reporter-output">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/choice>
 *                                               &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="is-config" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                               &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                                               &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                                               &lt;attribute name="depends-on-groups" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="depends-on-methods" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                           &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                 &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="skipped" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="passed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reporterOutput",
    "suite"
})
@XmlRootElement(name = "testng-results")
public class TestngResults {

    @XmlElement(name = "reporter-output", required = true)
    protected TestngResults.ReporterOutput reporterOutput;
    protected List<TestngResults.Suite> suite;
    @XmlAttribute(name = "skipped")
    protected Byte skipped;
    @XmlAttribute(name = "failed")
    protected Byte failed;
    @XmlAttribute(name = "total")
    protected Byte total;
    @XmlAttribute(name = "passed")
    protected Byte passed;

    /**
     * Gets the value of the reporterOutput property.
     * 
     * @return
     *     possible object is
     *     {@link TestngResults.ReporterOutput }
     *     
     */
    public TestngResults.ReporterOutput getReporterOutput() {
        return reporterOutput;
    }

    /**
     * Sets the value of the reporterOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestngResults.ReporterOutput }
     *     
     */
    public void setReporterOutput(TestngResults.ReporterOutput value) {
        this.reporterOutput = value;
    }

    /**
     * Gets the value of the suite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TestngResults.Suite }
     * 
     * 
     */
    public List<TestngResults.Suite> getSuite() {
        if (suite == null) {
            suite = new ArrayList<TestngResults.Suite>();
        }
        return this.suite;
    }

    /**
     * Gets the value of the skipped property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getSkipped() {
        return skipped;
    }

    /**
     * Sets the value of the skipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setSkipped(Byte value) {
        this.skipped = value;
    }

    /**
     * Gets the value of the failed property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getFailed() {
        return failed;
    }

    /**
     * Sets the value of the failed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setFailed(Byte value) {
        this.failed = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setTotal(Byte value) {
        this.total = value;
    }

    /**
     * Gets the value of the passed property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getPassed() {
        return passed;
    }

    /**
     * Sets the value of the passed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPassed(Byte value) {
        this.passed = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "line"
    })
    public static class ReporterOutput {

        protected List<String> line;

        /**
         * Gets the value of the line property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the line property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLine() {
            if (line == null) {
                line = new ArrayList<String>();
            }
            return this.line;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="groups">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="group" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="method" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="test" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="class" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="test-method" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;choice maxOccurs="unbounded" minOccurs="0">
     *                                       &lt;element name="params">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="value">
     *                                                             &lt;complexType>
     *                                                               &lt;simpleContent>
     *                                                                 &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                                                   &lt;attribute name="is-null" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                                                 &lt;/extension>
     *                                                               &lt;/simpleContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                         &lt;/sequence>
     *                                                         &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="exception">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="full-stacktrace" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="reporter-output">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/choice>
     *                                     &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="is-config" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                                     &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *                                     &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *                                     &lt;attribute name="depends-on-groups" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="depends-on-methods" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *                 &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *       &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "groups",
        "test"
    })
    public static class Suite {

        @XmlElement(required = true)
        protected TestngResults.Suite.Groups groups;
        protected List<TestngResults.Suite.Test> test;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "duration-ms")
        protected Short durationMs;
        @XmlAttribute(name = "started-at")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar startedAt;
        @XmlAttribute(name = "finished-at")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar finishedAt;

        /**
         * Gets the value of the groups property.
         * 
         * @return
         *     possible object is
         *     {@link TestngResults.Suite.Groups }
         *     
         */
        public TestngResults.Suite.Groups getGroups() {
            return groups;
        }

        /**
         * Sets the value of the groups property.
         * 
         * @param value
         *     allowed object is
         *     {@link TestngResults.Suite.Groups }
         *     
         */
        public void setGroups(TestngResults.Suite.Groups value) {
            this.groups = value;
        }

        /**
         * Gets the value of the test property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the test property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTest().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TestngResults.Suite.Test }
         * 
         * 
         */
        public List<TestngResults.Suite.Test> getTest() {
            if (test == null) {
                test = new ArrayList<TestngResults.Suite.Test>();
            }
            return this.test;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the durationMs property.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getDurationMs() {
            return durationMs;
        }

        /**
         * Sets the value of the durationMs property.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setDurationMs(Short value) {
            this.durationMs = value;
        }

        /**
         * Gets the value of the startedAt property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStartedAt() {
            return startedAt;
        }

        /**
         * Sets the value of the startedAt property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStartedAt(XMLGregorianCalendar value) {
            this.startedAt = value;
        }

        /**
         * Gets the value of the finishedAt property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFinishedAt() {
            return finishedAt;
        }

        /**
         * Sets the value of the finishedAt property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFinishedAt(XMLGregorianCalendar value) {
            this.finishedAt = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="group" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="method" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                           &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "group"
        })
        public static class Groups {

            protected List<TestngResults.Suite.Groups.Group> group;

            /**
             * Gets the value of the group property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the group property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getGroup().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TestngResults.Suite.Groups.Group }
             * 
             * 
             */
            public List<TestngResults.Suite.Groups.Group> getGroup() {
                if (group == null) {
                    group = new ArrayList<TestngResults.Suite.Groups.Group>();
                }
                return this.group;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="method" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "method"
            })
            public static class Group {

                protected List<TestngResults.Suite.Groups.Group.Method> method;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * Gets the value of the method property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the method property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getMethod().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TestngResults.Suite.Groups.Group.Method }
                 * 
                 * 
                 */
                public List<TestngResults.Suite.Groups.Group.Method> getMethod() {
                    if (method == null) {
                        method = new ArrayList<TestngResults.Suite.Groups.Group.Method>();
                    }
                    return this.method;
                }

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Method {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "signature")
                    protected String signature;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "class")
                    protected String clazz;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the signature property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSignature() {
                        return signature;
                    }

                    /**
                     * Sets the value of the signature property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSignature(String value) {
                        this.signature = value;
                    }

                    /**
                     * Gets the value of the name property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     * Sets the value of the name property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setName(String value) {
                        this.name = value;
                    }

                    /**
                     * Gets the value of the clazz property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getClazz() {
                        return clazz;
                    }

                    /**
                     * Sets the value of the clazz property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setClazz(String value) {
                        this.clazz = value;
                    }

                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="class" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="test-method" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;choice maxOccurs="unbounded" minOccurs="0">
         *                             &lt;element name="params">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="value">
         *                                                   &lt;complexType>
         *                                                     &lt;simpleContent>
         *                                                       &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                                                         &lt;attribute name="is-null" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                                       &lt;/extension>
         *                                                     &lt;/simpleContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                               &lt;/sequence>
         *                                               &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="exception">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="full-stacktrace" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="reporter-output">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/choice>
         *                           &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="is-config" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
         *                           &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *                           &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *                           &lt;attribute name="depends-on-groups" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="depends-on-methods" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *       &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "clazz"
        })
        public static class Test {

            @XmlElement(name = "class")
            protected List<TestngResults.Suite.Test.Class> clazz;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "duration-ms")
            protected Short durationMs;
            @XmlAttribute(name = "started-at")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar startedAt;
            @XmlAttribute(name = "finished-at")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar finishedAt;

            /**
             * Gets the value of the clazz property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the clazz property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getClazz().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TestngResults.Suite.Test.Class }
             * 
             * 
             */
            public List<TestngResults.Suite.Test.Class> getClazz() {
                if (clazz == null) {
                    clazz = new ArrayList<TestngResults.Suite.Test.Class>();
                }
                return this.clazz;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the durationMs property.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getDurationMs() {
                return durationMs;
            }

            /**
             * Sets the value of the durationMs property.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setDurationMs(Short value) {
                this.durationMs = value;
            }

            /**
             * Gets the value of the startedAt property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getStartedAt() {
                return startedAt;
            }

            /**
             * Sets the value of the startedAt property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setStartedAt(XMLGregorianCalendar value) {
                this.startedAt = value;
            }

            /**
             * Gets the value of the finishedAt property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getFinishedAt() {
                return finishedAt;
            }

            /**
             * Sets the value of the finishedAt property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setFinishedAt(XMLGregorianCalendar value) {
                this.finishedAt = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="test-method" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
             *                   &lt;element name="params">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="value">
             *                                         &lt;complexType>
             *                                           &lt;simpleContent>
             *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                                               &lt;attribute name="is-null" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                                             &lt;/extension>
             *                                           &lt;/simpleContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                     &lt;/sequence>
             *                                     &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="exception">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="full-stacktrace" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                           &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="reporter-output">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/choice>
             *                 &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="is-config" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
             *                 &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *                 &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *                 &lt;attribute name="depends-on-groups" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="depends-on-methods" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "testMethod"
            })
            public static class Class {

                @XmlElement(name = "test-method")
                protected List<TestngResults.Suite.Test.Class.TestMethod> testMethod;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * Gets the value of the testMethod property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the testMethod property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTestMethod().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TestngResults.Suite.Test.Class.TestMethod }
                 * 
                 * 
                 */
                public List<TestngResults.Suite.Test.Class.TestMethod> getTestMethod() {
                    if (testMethod == null) {
                        testMethod = new ArrayList<TestngResults.Suite.Test.Class.TestMethod>();
                    }
                    return this.testMethod;
                }

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
                 *         &lt;element name="params">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="value">
                 *                               &lt;complexType>
                 *                                 &lt;simpleContent>
                 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *                                     &lt;attribute name="is-null" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *                                   &lt;/extension>
                 *                                 &lt;/simpleContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                           &lt;/sequence>
                 *                           &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="exception">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="full-stacktrace" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="reporter-output">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/choice>
                 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="signature" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="is-config" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="duration-ms" type="{http://www.w3.org/2001/XMLSchema}short" />
                 *       &lt;attribute name="started-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
                 *       &lt;attribute name="finished-at" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
                 *       &lt;attribute name="depends-on-groups" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="depends-on-methods" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "content"
                })
                public static class TestMethod {

                    @XmlElementRefs({
                        @XmlElementRef(name = "reporter-output", type = JAXBElement.class),
                        @XmlElementRef(name = "params", type = JAXBElement.class),
                        @XmlElementRef(name = "exception", type = JAXBElement.class)
                    })
                    @XmlMixed
                    protected List<Serializable> content;
                    @XmlAttribute(name = "status")
                    protected String status;
                    @XmlAttribute(name = "signature")
                    protected String signature;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "is-config")
                    protected String isConfig;
                    @XmlAttribute(name = "duration-ms")
                    protected Short durationMs;
                    @XmlAttribute(name = "started-at")
                    @XmlSchemaType(name = "dateTime")
                    protected XMLGregorianCalendar startedAt;
                    @XmlAttribute(name = "finished-at")
                    @XmlSchemaType(name = "dateTime")
                    protected XMLGregorianCalendar finishedAt;
                    @XmlAttribute(name = "depends-on-groups")
                    protected String dependsOnGroups;
                    @XmlAttribute(name = "description")
                    protected String description;
                    @XmlAttribute(name = "depends-on-methods")
                    protected String dependsOnMethods;

                    /**
                     * Gets the value of the content property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the content property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getContent().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link JAXBElement }{@code <}{@link TestngResults.Suite.Test.Class.TestMethod.ReporterOutput }{@code >}
                     * {@link JAXBElement }{@code <}{@link TestngResults.Suite.Test.Class.TestMethod.Params }{@code >}
                     * {@link JAXBElement }{@code <}{@link TestngResults.Suite.Test.Class.TestMethod.Exception }{@code >}
                     * {@link String }
                     * 
                     * 
                     */
                    public List<Serializable> getContent() {
                        if (content == null) {
                            content = new ArrayList<Serializable>();
                        }
                        return this.content;
                    }

                    /**
                     * Gets the value of the status property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getStatus() {
                        return status;
                    }

                    /**
                     * Sets the value of the status property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setStatus(String value) {
                        this.status = value;
                    }

                    /**
                     * Gets the value of the signature property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSignature() {
                        return signature;
                    }

                    /**
                     * Sets the value of the signature property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSignature(String value) {
                        this.signature = value;
                    }

                    /**
                     * Gets the value of the name property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     * Sets the value of the name property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setName(String value) {
                        this.name = value;
                    }

                    /**
                     * Gets the value of the isConfig property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getIsConfig() {
                        return isConfig;
                    }

                    /**
                     * Sets the value of the isConfig property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setIsConfig(String value) {
                        this.isConfig = value;
                    }

                    /**
                     * Gets the value of the durationMs property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Short }
                     *     
                     */
                    public Short getDurationMs() {
                        return durationMs;
                    }

                    /**
                     * Sets the value of the durationMs property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Short }
                     *     
                     */
                    public void setDurationMs(Short value) {
                        this.durationMs = value;
                    }

                    /**
                     * Gets the value of the startedAt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public XMLGregorianCalendar getStartedAt() {
                        return startedAt;
                    }

                    /**
                     * Sets the value of the startedAt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public void setStartedAt(XMLGregorianCalendar value) {
                        this.startedAt = value;
                    }

                    /**
                     * Gets the value of the finishedAt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public XMLGregorianCalendar getFinishedAt() {
                        return finishedAt;
                    }

                    /**
                     * Sets the value of the finishedAt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public void setFinishedAt(XMLGregorianCalendar value) {
                        this.finishedAt = value;
                    }

                    /**
                     * Gets the value of the dependsOnGroups property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDependsOnGroups() {
                        return dependsOnGroups;
                    }

                    /**
                     * Sets the value of the dependsOnGroups property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDependsOnGroups(String value) {
                        this.dependsOnGroups = value;
                    }

                    /**
                     * Gets the value of the description property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDescription() {
                        return description;
                    }

                    /**
                     * Sets the value of the description property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDescription(String value) {
                        this.description = value;
                    }

                    /**
                     * Gets the value of the dependsOnMethods property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDependsOnMethods() {
                        return dependsOnMethods;
                    }

                    /**
                     * Sets the value of the dependsOnMethods property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDependsOnMethods(String value) {
                        this.dependsOnMethods = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="full-stacktrace" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "message",
                        "fullStacktrace"
                    })
                    public static class Exception {

                        @XmlElement(required = true)
                        protected String message;
                        @XmlElement(name = "full-stacktrace", required = true)
                        protected String fullStacktrace;
                        @XmlAttribute(name = "class")
                        protected String clazz;

                        /**
                         * Gets the value of the message property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getMessage() {
                            return message;
                        }

                        /**
                         * Sets the value of the message property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setMessage(String value) {
                            this.message = value;
                        }

                        /**
                         * Gets the value of the fullStacktrace property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFullStacktrace() {
                            return fullStacktrace;
                        }

                        /**
                         * Sets the value of the fullStacktrace property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFullStacktrace(String value) {
                            this.fullStacktrace = value;
                        }

                        /**
                         * Gets the value of the clazz property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getClazz() {
                            return clazz;
                        }

                        /**
                         * Sets the value of the clazz property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setClazz(String value) {
                            this.clazz = value;
                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="value">
                     *                     &lt;complexType>
                     *                       &lt;simpleContent>
                     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                     *                           &lt;attribute name="is-null" type="{http://www.w3.org/2001/XMLSchema}string" />
                     *                         &lt;/extension>
                     *                       &lt;/simpleContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                 &lt;/sequence>
                     *                 &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "param"
                    })
                    public static class Params {

                        protected List<TestngResults.Suite.Test.Class.TestMethod.Params.Param> param;

                        /**
                         * Gets the value of the param property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the JAXB object.
                         * This is why there is not a <CODE>set</CODE> method for the param property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getParam().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link TestngResults.Suite.Test.Class.TestMethod.Params.Param }
                         * 
                         * 
                         */
                        public List<TestngResults.Suite.Test.Class.TestMethod.Params.Param> getParam() {
                            if (param == null) {
                                param = new ArrayList<TestngResults.Suite.Test.Class.TestMethod.Params.Param>();
                            }
                            return this.param;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="value">
                         *           &lt;complexType>
                         *             &lt;simpleContent>
                         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                         *                 &lt;attribute name="is-null" type="{http://www.w3.org/2001/XMLSchema}string" />
                         *               &lt;/extension>
                         *             &lt;/simpleContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *       &lt;/sequence>
                         *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "value"
                        })
                        public static class Param {

                            @XmlElement(required = true)
                            protected TestngResults.Suite.Test.Class.TestMethod.Params.Param.Value value;
                            @XmlAttribute(name = "index")
                            protected Byte index;

                            /**
                             * Gets the value of the value property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link TestngResults.Suite.Test.Class.TestMethod.Params.Param.Value }
                             *     
                             */
                            public TestngResults.Suite.Test.Class.TestMethod.Params.Param.Value getValue() {
                                return value;
                            }

                            /**
                             * Sets the value of the value property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link TestngResults.Suite.Test.Class.TestMethod.Params.Param.Value }
                             *     
                             */
                            public void setValue(TestngResults.Suite.Test.Class.TestMethod.Params.Param.Value value) {
                                this.value = value;
                            }

                            /**
                             * Gets the value of the index property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link Byte }
                             *     
                             */
                            public Byte getIndex() {
                                return index;
                            }

                            /**
                             * Sets the value of the index property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link Byte }
                             *     
                             */
                            public void setIndex(Byte value) {
                                this.index = value;
                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;simpleContent>
                             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                             *       &lt;attribute name="is-null" type="{http://www.w3.org/2001/XMLSchema}string" />
                             *     &lt;/extension>
                             *   &lt;/simpleContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "value"
                            })
                            public static class Value {

                                @XmlValue
                                protected String value;
                                @XmlAttribute(name = "is-null")
                                protected String isNull;

                                /**
                                 * Gets the value of the value property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getValue() {
                                    return value;
                                }

                                /**
                                 * Sets the value of the value property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setValue(String value) {
                                    this.value = value;
                                }

                                /**
                                 * Gets the value of the isNull property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getIsNull() {
                                    return isNull;
                                }

                                /**
                                 * Sets the value of the isNull property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setIsNull(String value) {
                                    this.isNull = value;
                                }

                            }

                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "line"
                    })
                    public static class ReporterOutput {

                        @XmlElement(required = true)
                        protected String line;

                        /**
                         * Gets the value of the line property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getLine() {
                            return line;
                        }

                        /**
                         * Sets the value of the line property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setLine(String value) {
                            this.line = value;
                        }

                    }

                }

            }

        }

    }

}
