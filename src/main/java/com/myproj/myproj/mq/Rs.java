package com.myproj.myproj.mq;

import com.google.common.base.MoreObjects;
import com.myproj.myproj.utils.BusinessException;
import com.myproj.myproj.utils.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by wangjinyu on 2019/5/9 15:45.
 */
@Api(value = "", description = "用戶中心接口模块", tags = "用户中心展示接口")
@RestController
public class Rs {
    /*public static void main(String[] args) {
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date parse = sfd.parse("2019-05-08");
            System.out.println(parse.toInstant());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/

    @ApiOperation("用户中心展示")
    @RequestMapping(method = GET, path = "/userCenter/{orgCode}", produces = "application/json")
    public ResponseEntity qureyOrgInfoAll(@PathVariable("orgCode") String orgCode) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
           // List<Map> list = orgInfoDao.findSecondLevelOrgList();
            responseEntity.setCode("1");
            responseEntity.setResult("");
            return responseEntity;
        } catch (BusinessException ex) {
            responseEntity.setCode("0");
            responseEntity.setMessage("查询失败");
            return responseEntity;
        }
    }
    @ApiOperation("后台-添加单位")
    @RequestMapping(method = POST, value = "/orgInfo/add",
            consumes = "application/json",  produces = "application/json")
    public ResponseEntity addOpsOrgInfo(
            @Valid @RequestBody @ApiParam("orgInfo")
                    AddOpsOrgInfoRequest request, HttpServletRequest httpServletRequest) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
          /*  if (logger.isDebugEnabled()) {
                logger.debug("enter OrgInfoOpsActionController.addOpsOrgInfo: {}", request);
            }

            OrgInfo build = request.toBuilder().build();
            OrgInfo orgInfo = orgInfoService.addOpsOrgInfo(build);

            if (logger.isDebugEnabled()) {
                logger.debug("************orgInfo**********: {}", orgInfo);
            }*/
            responseEntity.setCode("1");
            responseEntity.setMessage("新增成功");
            responseEntity.setResult("");
        } catch (BusinessException e) {
            responseEntity.setCode("0");
            responseEntity.setMessage("新增失败：" + e.getMessage());
        }

        return responseEntity;
    }
    @ApiModel("AddOpsOrgInfoRequest")
    public static final class AddOpsOrgInfoRequest {

        @Size(max = 64, message = "唯一标识长度不符合要求")
        @ApiModelProperty("唯一标识")
        String id;

        @Size(max = 64, message = "机构编码(本系统企业唯一标识)长度不符合要求")
        @ApiModelProperty("机构编码(本系统企业唯一标识)")
        String orgCode;

        @Size(max = 256, message = "单位名称长度不符合要求")
        @ApiModelProperty("单位名称")
        String orgName;

        @Size(max = 64, message = "用户名称长度不符合要求")
        @ApiModelProperty("用户名称")
        String userName;

        @Size(max = 64, message = "财务管控单位编码长度不符合要求")
        @ApiModelProperty("财务管控单位编码")
        String ygEcd;

        @Size(max = 64, message = "ERP单位编码长度不符合要求")
        @ApiModelProperty("ERP单位编码")
        String erpEcd;

        @Size(max = 64, message = "上级单位标识长度不符合要求")
        @ApiModelProperty("上级单位标识")
        String parentId;

        @Size(max = 32, message = "证件类别：0.组织机构代码  1.统一社会信用代码 长度不符合要求")
        @ApiModelProperty("证件类别：0.组织机构代码  1.统一社会信用代码 ")
        String certType;

        @Size(max = 64, message = "证件号码 长度不符合要求")
        @ApiModelProperty("证件号码 ")
        String certNo;

        @Size(max = 256, message = "证件图片长度不符合要求")
        @ApiModelProperty("证件图片")
        String certUrl;

        @Size(max = 64, message = "营业执照号长度不符合要求")
        @ApiModelProperty("营业执照号")
        String businessNo;

        @Size(max = 64, message = "税务登记号长度不符合要求")
        @ApiModelProperty("税务登记号")
        String taxNo;

        @Size(max = 256, message = "营业执照附件长度不符合要求")
        @ApiModelProperty("营业执照附件")
        String businessFileUrl;

        @Size(max = 256, message = "税务登记证附件长度不符合要求")
        @ApiModelProperty("税务登记证附件")
        String taxFileUrl;

        @Size(max = 32, message = "机构类型:0：主业单位 1：金融机构  2：产业单位 3：集体企业 4：财务部长度不符合要求")
        @ApiModelProperty("机构类型:0：主业单位 1：金融机构  2：产业单位 3：集体企业 4：财务部")
        String orgType;

        @Size(max = 16, message = "财务部联系方式长度不符合要求")
        @ApiModelProperty("财务部联系方式")
        String financePhone;

        @Size(max = 128, message = "财务部联系人长度不符合要求")
        @ApiModelProperty("财务部联系人")
        String financeName;

        @Size(max = 16, message = "物资部联系方式长度不符合要求")
        @ApiModelProperty("物资部联系方式")
        String materialPhone;

        @Size(max = 128, message = "物资部联系人长度不符合要求")
        @ApiModelProperty("物资部联系人")
        String materialName;

        @Size(max = 1, message = "企业状态0：未激活 1：待审核 2：已激活长度不符合要求")
        @ApiModelProperty("企业状态0：未激活 1：待审核 2：已激活")
        String orgState;

        @Size(max = 1, message = "企业数据来源 0：录入 1：接口长度不符合要求")
        @ApiModelProperty("企业数据来源 0：录入 1：接口")
        String orgSource;

        @Size(max = 16, message = "激活码长度不符合要求")
        @ApiModelProperty("激活码")
        String activateCode;

        @Size(max = 1, message = "激活码是否激活：1.激活 0.未激活长度不符合要求")
        @ApiModelProperty("激活码是否激活：1.激活 0.未激活")
        String isActivate;

        @Size(max = 32, message = "企业规模长度不符合要求")
        @ApiModelProperty("企业规模")
        String enterpriseScale;

        @ApiModelProperty("注册资金 单位：元")
        java.math.BigDecimal registeredCapital;

        @ApiModelProperty("成立时间")
        java.time.Instant foundDate;

        @Size(max = 32, message = "注册地址  省市县长度不符合要求")
        @ApiModelProperty("注册地址  省市县")
        String areaCode;

        @Size(max = 256, message = "详细地址长度不符合要求")
        @ApiModelProperty("详细地址")
        String address;

        @Size(max = 1024, message = "经营范围长度不符合要求")
        @ApiModelProperty("经营范围")
        String operationScope;

        @Size(max = 32, message = "电话长度不符合要求")
        @ApiModelProperty("电话")
        String phone;

        @Size(max = 32, message = "传真长度不符合要求")
        @ApiModelProperty("传真")
        String fax;

        @Size(max = 1, message = "删除标识  Y：是  N：否长度不符合要求")
        @ApiModelProperty("删除标识  Y：是  N：否")
        String deleteFlag;

        @ApiModelProperty("删除时间")
        java.time.Instant deleteTime;

        // ukeyEmailInfo params
        @Size(max = 128, message = "收件人姓名长度不符合要求")
        @ApiModelProperty("收件人姓名")
        String addresseeName;

        @Size(max = 16, message = "收件人联系方式长度不符合要求")
        @ApiModelProperty("收件人联系方式")
        String addresseePhone;

        @Size(max = 256, message = "邮寄地址长度不符合要求")
        @ApiModelProperty("邮寄地址")
        String addresseeEmail;

        @Size(max = 16, message = "省份编码不符合要求")
        @ApiModelProperty("省份编码")
        String province;

        @Size(max = 256, message = "省份名称不符合要求")
        @ApiModelProperty("省份名称")
        String provinceName;

        public String getId() {
            return this.id;
        }

        public void setId(String value) {
            this.id = value;
        }

        public String getOrgCode() {
            return this.orgCode;
        }

        public void setOrgCode(String value) {
            this.orgCode = value;
        }

        public String getOrgName() {
            return this.orgName;
        }

        public void setOrgName(String value) {
            this.orgName = value;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setUserName(String value) {
            this.userName = value;
        }

        public String getYgEcd() {
            return this.ygEcd;
        }

        public void setYgEcd(String value) {
            this.ygEcd = value;
        }

        public String getErpEcd() {
            return this.erpEcd;
        }

        public void setErpEcd(String value) {
            this.erpEcd = value;
        }

        public String getParentId() {
            return this.parentId;
        }

        public void setParentId(String value) {
            this.parentId = value;
        }

        public String getCertType() {
            return this.certType;
        }

        public void setCertType(String value) {
            this.certType = value;
        }

        public String getCertNo() {
            return this.certNo;
        }

        public void setCertNo(String value) {
            this.certNo = value;
        }

        public String getCertUrl() {
            return this.certUrl;
        }

        public void setCertUrl(String value) {
            this.certUrl = value;
        }

        public String getBusinessNo() {
            return this.businessNo;
        }

        public void setBusinessNo(String value) {
            this.businessNo = value;
        }

        public String getTaxNo() {
            return this.taxNo;
        }

        public void setTaxNo(String value) {
            this.taxNo = value;
        }

        public String getBusinessFileUrl() {
            return this.businessFileUrl;
        }

        public void setBusinessFileUrl(String value) {
            this.businessFileUrl = value;
        }

        public String getTaxFileUrl() {
            return this.taxFileUrl;
        }

        public void setTaxFileUrl(String value) {
            this.taxFileUrl = value;
        }

        public String getOrgType() {
            return this.orgType;
        }

        public void setOrgType(String value) {
            this.orgType = value;
        }

        public String getFinancePhone() {
            return this.financePhone;
        }

        public void setFinancePhone(String value) {
            this.financePhone = value;
        }

        public String getFinanceName() {
            return this.financeName;
        }

        public void setFinanceName(String value) {
            this.financeName = value;
        }

        public String getMaterialPhone() {
            return this.materialPhone;
        }

        public void setMaterialPhone(String value) {
            this.materialPhone = value;
        }

        public String getMaterialName() {
            return this.materialName;
        }

        public void setMaterialName(String value) {
            this.materialName = value;
        }

        public String getOrgState() {
            return this.orgState;
        }

        public void setOrgState(String value) {
            this.orgState = value;
        }

        public String getOrgSource() {
            return this.orgSource;
        }

        public void setOrgSource(String value) {
            this.orgSource = value;
        }

        public String getActivateCode() {
            return this.activateCode;
        }

        public void setActivateCode(String value) {
            this.activateCode = value;
        }

        public String getIsActivate() {
            return this.isActivate;
        }

        public void setIsActivate(String value) {
            this.isActivate = value;
        }

        public String getEnterpriseScale() {
            return this.enterpriseScale;
        }

        public void setEnterpriseScale(String value) {
            this.enterpriseScale = value;
        }

        public java.math.BigDecimal getRegisteredCapital() {
            return this.registeredCapital;
        }

        public void setRegisteredCapital(java.math.BigDecimal value) {
            this.registeredCapital = value;
        }

        public java.time.Instant getFoundDate() {
            return this.foundDate;
        }

        public void setFoundDate(java.time.Instant value) {
            this.foundDate = value;
        }

        public String getAreaCode() {
            return this.areaCode;
        }

        public void setAreaCode(String value) {
            this.areaCode = value;
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String value) {
            this.address = value;
        }

        public String getOperationScope() {
            return this.operationScope;
        }

        public void setOperationScope(String value) {
            this.operationScope = value;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String value) {
            this.phone = value;
        }

        public String getFax() {
            return this.fax;
        }

        public void setFax(String value) {
            this.fax = value;
        }

        public String getDeleteFlag() {
            return this.deleteFlag;
        }

        public void setDeleteFlag(String value) {
            this.deleteFlag = value;
        }

        public java.time.Instant getDeleteTime() {
            return this.deleteTime;
        }

        public void setDeleteTime(java.time.Instant value) {
            this.deleteTime = value;
        }

        public String getAddresseeName() {
            return addresseeName;
        }

        public void setAddresseeName(String addresseeName) {
            this.addresseeName = addresseeName;
        }

        public String getAddresseePhone() {
            return addresseePhone;
        }

        public void setAddresseePhone(String addresseePhone) {
            this.addresseePhone = addresseePhone;
        }

        public String getAddresseeEmail() {
            return addresseeEmail;
        }

        public void setAddresseeEmail(String addresseeEmail) {
            this.addresseeEmail = addresseeEmail;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("id", id)
                    .add("orgCode", orgCode)
                    .add("orgName", orgName)
                    .add("userName", userName)
                    .add("ygEcd", ygEcd)
                    .add("erpEcd", erpEcd)
                    .add("parentId", parentId)
                    .add("certType", certType)
                    .add("certNo", certNo)
                    .add("certUrl", certUrl)
                    .add("businessNo", businessNo)
                    .add("taxNo", taxNo)
                    .add("businessFileUrl", businessFileUrl)
                    .add("taxFileUrl", taxFileUrl)
                    .add("orgType", orgType)
                    .add("financePhone", financePhone)
                    .add("financeName", financeName)
                    .add("materialPhone", materialPhone)
                    .add("materialName", materialName)
                    .add("orgState", orgState)
                    .add("orgSource", orgSource)
                    .add("activateCode", activateCode)
                    .add("isActivate", isActivate)
                    .add("enterpriseScale", enterpriseScale)
                    .add("registeredCapital", registeredCapital)
                    .add("foundDate", foundDate)
                    .add("areaCode", areaCode)
                    .add("address", address)
                    .add("operationScope", operationScope)
                    .add("phone", phone)
                    .add("fax", fax)
                    .add("deleteFlag", deleteFlag)
                    .add("deleteTime", deleteTime)
                    .add("addresseeName", addresseeName)
                    .add("addresseePhone", addresseePhone)
                    .add("addresseeEmail", addresseeEmail)
                    .toString();
        }

    }
}
