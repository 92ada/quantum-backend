package com.techncat.quantum.app.excel.model.finance;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.finance.SocialInsurance;
import lombok.Data;

import java.util.Date;

@Data
public class SocialInsuranceRow {
    
    @ExcelField(headName = "工号")
    private String personSid;
    @ExcelField(headName = "姓名")
    private String personName;

    @ExcelField(headName = "经费来源")
    private String fund_source;

    @ExcelField(headName = "日期")
    private String date;

    @ExcelField(headName = "应收金额总计")
    private String receivable_total;
    @ExcelField(headName = "应收金额（个人缴）")
    private String receivable_by_individual;
    @ExcelField(headName = "应收金额（单位缴）")
    private String receivable_by_institution;
    @ExcelField(headName = "养老保险缴费基数")
    private String pension_base_amount;
    @ExcelField(headName = "养老保险（个人缴）")
    private String pension_by_individual;
    @ExcelField(headName = "养老保险（单位缴）")
    private String pension_by_institution;
    @ExcelField(headName = "医疗保险缴费基数")
    private String medical_base_amount;
    @ExcelField(headName = "医疗保险（个人缴）")
    private String medical_by_individual;
    @ExcelField(headName = "医疗保险（单位缴）")
    private String medical_by_institution;
    @ExcelField(headName = "工伤保险缴费基数")
    private String work_injury_base_amount;
    @ExcelField(headName = "工伤保险（单位缴）")
    private String work_injury_by_institution;
    @ExcelField(headName = "医疗保险缴费基数")
    private String unemployment_base_amount;
    @ExcelField(headName = "医疗保险（个人缴）")
    private String unemployment_by_individual;
    @ExcelField(headName = "医疗保险（单位缴）")
    private String unemployment_by_institution;
    @ExcelField(headName = "生育医疗缴费基数")
    private String fertility_base_amount;
    @ExcelField(headName = "生育医疗（单位缴）")
    private String fertility_by_institution;

    public static SocialInsuranceRow render(SocialInsurance insurance) {
        SocialInsuranceRow row = new SocialInsuranceRow();
        if (insurance.getPeople() != null) {
            row.personSid = insurance.getPeople().getSid();
            row.personName = insurance.getPeople().getName();
        }

        row.fund_source = insurance.getFund_source();
        row.date = FormatUtil.formatDate(insurance.getDate());

        row.receivable_total = FormatUtil.format(insurance.getReceivable_total());
        row.receivable_by_individual = FormatUtil.format(insurance.getReceivable_by_individual());
        row.receivable_by_institution = FormatUtil.format(insurance.getReceivable_by_institution());
        row.pension_base_amount = FormatUtil.format(insurance.getPension_base_amount());
        row.pension_by_individual = FormatUtil.format(insurance.getPension_by_individual());
        row.pension_by_institution = FormatUtil.format(insurance.getPension_by_institution());
        row.medical_base_amount = FormatUtil.format(insurance.getMedical_base_amount());
        row.medical_by_individual = FormatUtil.format(insurance.getMedical_by_individual());
        row.medical_by_institution = FormatUtil.format(insurance.getMedical_by_institution());
        row.work_injury_base_amount = FormatUtil.format(insurance.getWork_injury_base_amount());
        row.work_injury_by_institution = FormatUtil.format(insurance.getWork_injury_by_institution());
        row.unemployment_base_amount = FormatUtil.format(insurance.getUnemployment_base_amount());
        row.unemployment_by_individual = FormatUtil.format(insurance.getUnemployment_by_individual());
        row.unemployment_by_institution = FormatUtil.format(insurance.getUnemployment_by_institution());
        row.fertility_base_amount = FormatUtil.format(insurance.getFertility_base_amount());
        row.fertility_by_institution = FormatUtil.format(insurance.getFertility_by_institution());

        return row;
    }

    public static SocialInsurance load(SocialInsuranceRow row) {
        if (row.personSid == null || row.personSid.trim().length() == 0) return null;
        SocialInsurance p = new SocialInsurance();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());

        p.setPeople(null);

        p.setFund_source(row.fund_source);
        p.setDate(FormatUtil.formatDate(row.date));

        p.setReceivable_total(FormatUtil.toBigDecimal(row.receivable_total));
        p.setReceivable_by_individual(FormatUtil.toBigDecimal(row.receivable_by_individual));
        p.setReceivable_by_institution(FormatUtil.toBigDecimal(row.receivable_by_institution));
        p.setPension_base_amount(FormatUtil.toBigDecimal(row.pension_base_amount));
        p.setPension_by_individual(FormatUtil.toBigDecimal(row.pension_by_individual));
        p.setPension_by_institution(FormatUtil.toBigDecimal(row.pension_by_institution));
        p.setMedical_base_amount(FormatUtil.toBigDecimal(row.medical_base_amount));
        p.setMedical_by_individual(FormatUtil.toBigDecimal(row.medical_by_individual));
        p.setMedical_by_institution(FormatUtil.toBigDecimal(row.medical_by_institution));
        p.setWork_injury_base_amount(FormatUtil.toBigDecimal(row.work_injury_base_amount));
        p.setWork_injury_by_institution(FormatUtil.toBigDecimal(row.work_injury_by_institution));
        p.setUnemployment_base_amount(FormatUtil.toBigDecimal(row.unemployment_base_amount));
        p.setUnemployment_by_individual(FormatUtil.toBigDecimal(row.unemployment_by_individual));
        p.setUnemployment_by_institution(FormatUtil.toBigDecimal(row.unemployment_by_institution));
        p.setFertility_base_amount(FormatUtil.toBigDecimal(row.fertility_base_amount));
        p.setFertility_by_institution(FormatUtil.toBigDecimal(row.fertility_by_institution));
        return p;
    }
}
