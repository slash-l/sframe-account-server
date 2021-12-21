package com.sframe.app.base.DO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sframe.app.common.util.SpringSecurityAuditorAware;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * @ClassName BaseDO
 * @Description 基础 DO 基类
 * @Author mumu
 * @Date 2020/3/14 4:49 下午
 * @Version 1.0
 */
@Data
@MappedSuperclass //表示将其属性标注到子类上，从而映射到数据库中
public class BaseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公共主键 ID
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    /**
     * 创建时间
     */
    @CreatedDate
    protected LocalDateTime cstCreate;

    /**
     * 创建人
     */
    @CreatedBy
    protected String createUser;

    /**
     * 更新时间
     */
    @LastModifiedDate
    protected LocalDateTime cstModified;

    /**
     * 更新人
     */
    @LastModifiedBy
    protected String updateUser;

    /**
     * 日志跟踪 ID
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String logId = UUID.randomUUID().toString();

    @PrePersist
    protected void onCreate() {
        this.cstCreate = LocalDateTime.now();
        this.cstModified = LocalDateTime.now();
        Optional<UserDetails> value = SpringSecurityAuditorAware.getCurrentUser();
        if (value.isPresent()) {
            this.createUser = value.get().getUsername();
            this.updateUser = value.get().getUsername();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.cstModified = LocalDateTime.now();
        Optional<UserDetails> value = SpringSecurityAuditorAware.getCurrentUser();
        if (value.isPresent()) {
            this.updateUser = value.get().getUsername();
        }
    }

}
