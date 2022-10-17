package com.flrjcx.xypt.common.enums;


import com.flrjcx.xypt.common.constants.IResultCode;

/**
 * @author quanchao
 */
public enum ResultCodeEnum implements IResultCode {

    /**
     * 成功消息码
     */
    SUCCESS(999999, "成功"),

    /**
     * 失败消息码
     */
    FAIL(0, "失败"),

    /**
     * 登录消息码
     */
    USER_LOGIN_CODE_TECHNICAL_ERROR(100001, "技术用户不允许登录系统！"),
    USER_LOGIN_CODE_ACCESS_IP_ERROR(100002, "客户端登录IP允许范围内！"),
    USER_LOGIN_CODE_USER_LOCKED_ERROR(100003, "用户已被锁定，请联系管理员！"),
    USER_LOGIN_CODE_USER_INVALID_ERROR(100004, "用户待激活，请联系管理员！"),
    USER_LOGIN_CODE_USER_DELETED_ERROR(100005, "用户已被删除，请联系管理员！"),
    USER_LOGIN_CODE_IS_NOT_PWD_ERROR(100006, "账号不允许密码登录！"),
    USER_LOGIN_CODE_IP_NOT_ACCESS_PWD_ERROR(100007, "登录客户端IP不在允许密码登录IP范围内！"),
    USER_LOGIN_CODE_UN_VALID_FROM_ERROR(100008, "账号还未到开始使用期限！"),
    USER_LOGIN_CODE_INVALID_ERROR(100009, "账号已过有效期！"),
    USER_LOGIN_CODE_PASSWORD_INVALID_ERROR(100010, "账号密码已过期！"),
    USER_NOT_EXSIT_ERROR(100011, "用户不存在"),
    USER_LOGIN_PWD_ERROR_CODE(100012, "用户名登录密码错误!"),
    USER_LOGIN_OTHER_CODE(100013, "用户已在其他客户端登录!"),
    ERROR_CODE_NAME_REQUIRED(100014, "用户名必填"),
    ERROR_CODE_PASSWORD_ERROR(100015, "密码必填"),
    ERROR_CODE_TOKEN_ERROR(100016, "token必填"),
    ERROR_CODE_INTOKEN_ERROR(100017, "token无效"),
    CODE_EXSIT_POLICENO(100018, "警号已经存在！"),
    USER_ID_EXSIT_ERROR(100019, "用户ID不能为空"),

    /**
     * 接口转发服务编码
     */
    ERROR_CODE_HIK_API_URL_EMPTY(200000, "请求url不能为空！"),
    ERROR_CODE_HIK_API_FORWARD(200001, "接口转发错误！"),


    /**
     * 角色错误码
     */
    ERROR_ROLE_EMPTY_CODE(110001, "角色编码不能为空！"),
    ERROR_ROLE_EMPTY_NAME(110002, "角色名称不能为空！"),
    ERROR_ROLE_EXIST_NAME(110003, "角色编码已经存在！"),
    ERROR_ROLE_INSERT(110004, "增加角色失败！"),
    ERROR_ROLE_DETAIL(110005, "获取角色信息失败！"),
    ERROR_ROLE_DELETE(110006, "删除角色失败！"),
    ERROR_ROLE_EMPTY_ID(110007, "角色ID不能为空！"),
    ERROR_ROLE_QUERY_LIST(110008, "获取角色列表信息失败！"),
    ERROR_ROLE_UPDATE(110009, "修改角色失败！"),

    ERROR_ROLE_TEMPLATE_NAME_EMPTY(110010, "角色模板不能为空！"),
    ERROR_ROLE_TEMPLATE_NAME_EXIST(110011, "角色模板名称已经存在！"),
    ERROR_ROLE_TEMPLATE_NAME_INSERT(110012, "增加角色模板失败！"),
    ERROR_ROLE_TEMPLATE_QUERY_LIST(110013, "获取角色模板列表信息失败！"),
    ERROR_ROLE_TEMPLATE_UPDATE(110014, "修改角色模板列表信息失败！"),
    ERROR_ROLE_TEMPLATE_DELETE(110015, "删除角色模板列表信息失败！"),

    /**
     * 功能模块错误码
     */
    ERROR_MODULE_NAME_EMPTY(120001, "功能模块名称不能为空！"),
    ERROR_MODULE_KEY_EMPTY(120002, "功能模块编码不能为空！"),
    ERROR_MODULE_KEY_INVALID(120003, "功能模块编码只能有大写字母、数字、下划线组成，且只能以大写字母开头！"),
    ERROR_MODULE_KEY_EXIST(120004, "功能模块编码已经存在！"),
    ERROR_MODULE_ADD(120005, "功能模块增加失败！"),
    ERROR_MODULE_UPDATE(120006, "功能模块修改失败！"),
    ERROR_MODULE_DELETE(120007, "功能模块删除失败！"),
    ERROR_MODULE_SORT(120008, "功能模块移动操作失败！"),
    ERROR_PARENT_MODULE_KEY_INVALID(120009, "上级功能模块不存在！"),
    ERROR_MODULE_QUERY_LIST(120010, "获取模块列表信息失败！"),
    ERROR_MODULE_NAME_INVALID(120011, "模块名称只能为中文！"),

    /**
     * 日志信息
     */
    ERROR_OPERATION_LOG_ADD(130000, "增加日志失败！"),
    ERROR_OPERATION_LOG_QUERY_PAGE(130001, "获取日志列表信息失败！"),
    ERROR_OPERATION_LOG_EVENT_ADD(130002, "增加日志事件失败！"),
    ERROR_OPERATION_LOG_EVENT_GET(130003, "获取日志事件失败！"),
    ERROR_OPERATION_LOG_EVENT_UPDATE(130004, "修改日志事件失败！"),
    ERROR_OPERATION_LOG_EVENT_DELETE(130005, "删除日志事件失败！"),
    ERROR_OPERATION_LOG_EVENT_QUERY(130006, "分页获取日志事件失败！"),
    ERROR_API_LOG_ADD(130007, "增加api操作日志失败！"),
    @SuppressWarnings("unused")
    CODE_PARAM_ERROR(40003, "参数错误"),
    USER_EXSIT_ERROR(40004, "用户已经注册"),

    CODE_INVALID_PHONE(40006, "手机号码格式错误"),
    CODE_EXSIT_PHONE(40007, "手机已注册"),
    CODE_EXSIT_PHONEORIDCARD(40008, "手机号或身份证号已存在"),
    CODE_EXSIT_CATENAME(40009, "分组类别名称已存在"),
    CODE_EXSIT_GROUPNAME(40010, "分组名称已存在"),
    PHONE_NOT_EXSIT_ERROR(40301, "手机号码不能为空"),
    USER_TYPE_ERROR(40302, "用户类型错误"),
    CODE_FUNCTIONTYPE_ERROR(40303, "验证码用途不能为空"),
    CODE_CLIP_ALREAY_REQUEST(40900, "指定的开始时间和结束时间已经剪辑过"),
    CODE_CLIP_INTEVEL_OVER(40600, "指定的时间超过限制，不被接受"),
    CODE_CLIP_NOT_EXIST(40400, "指定的时间段无数据"),
    PHONE_DUPLICATE_ERROR(403010, "手机号码重复"),
    NAME_PASSWORD_ERROR(403011, "手机号或密码错误"),
    MOBILE_CITY_ERROR(403014, "注册未通过，该产品仅对{}本地号码开放，敬请谅解"),
    ROLES_NAME_ERROR(40024, "角色名称重复"),


    CODE_OLD_PASSWORD_ERR(40304, "旧密码不正确"),
    CODE_CHECK_PASSWORD_ERR(40305, "密码不正确"),
    VERIFICATIONCODE_ERROR(40306, "验证码不存在或已过期，请重新输入"),
    VERIFICATIONCODE_ERROR_EXPIRE(40308, "验证码不存在或已过期，请重新输入"),
    VERIFICATIONCODE_SEND_ERROR(40307, "验证码发送失败"),
    VERIFICATIONCODE_SEND_OVERFLOW(40307, "验证码发送操作次数"),
    IMG_VERIFY_ERROR(4037, "图形验证码发送失败"),
    EXIST_CF_PWD(40308, "密码已添加，您可以修改"),
    CODE_NO_AUTHORITY(40329, "权限不足"),
    CODE_FROM_TOKEN_NO_USER(40335, "token中,获取不到用户标识"),
    OPERATION_ERROR(40336, "此用户无权做此操作"),
    NOT_FOUND_DESCRIPTION(40344, "不能找到value,通过这个key"),
    CODE_SYSTEM_ERROR(50001, "服务器错误"),
    ERROR_CODE_USER_KEY_NOT_FOUND(102011, "用户key没有找到"),
    TOO_FREQUENT_LOGIN(50103, "登录过于频繁,请一分钟后重试"),

    WORKFLOW_DEPART_EMPTY(60104, "单位不能为空！"),

    WORKFLOW_INTELLIGENCE_PERSON_EMPTY(60105, "涉事人员名单不能为空！"),

    WORKFLOW_INTELLIGENCE_ACTIVITY_TIME_EMPTY(60106, "行动时间不能为空！"),
    
    TOO_FREQUENT_REQUEST(50104, "请求过于频繁"),
    USERNAME_OR_PASSWORD_ERROR(50105, "账号或密码错误,请重新输入"),
    CURRENT_USER_UNUSUAL(50106, "当前登录账号异常,请联系管理员"),
    CURRENT_ACCOUNT_IS_LOCKED(50107, "您的账号已被锁定,请十分钟后重试"),
    TOO_FREQUENT_WRONG_LOGIN(50108, "密码错误,您还可以输入##次"),
    NOT_LOGIN_CURRENT_DEVICE_IN_30_DAYS(50109, "您的账号30日内未在本设备登录,请输入验证码"),
    CURRENT_ACCOUNT_NOT_BIND_PHONE(50110, "您的账号未绑定手机号,请联系管理员"),
    ERROR_UPLOADFILE_FAILED(508000, "上传文件失败！"),
    ERROR_CODE_50111(50111, "根据权限查询用户失败 "),
    ERROR_CODE_50000(50000, "微服务调用异常 "),
    ERROR_CODE_50200(50200, "根据组织机构ID查询组织机构信息失败"),
    ERROR_CODE_50201(50201, "根据应用系统查询组织机构信息失败"),
    ERROR_CODE_50202(50202, "用户ID为空"),
    ERROR_CODE_50203(50203, "用户未分配应用系统或应用系统下账号被禁用,请联系管理员处理"),
    ERROR_CODE_50204(50204, "用户组织机构为空"),
    ERROR_CODE_50205(50205, "用户类型为空"),
    ERROR_CODE_50206(50206, "根据用户统计设备数量失败"),
    ERROR_CODE_50207(50207, "分配设备到组织机构失败"),
    ERROR_CODE_50208(50208, "根据应用系统查询设备失败"),
    ERROR_CODE_50209(50209, "根据组织机构查询设备失败"),
    ERROR_CODE_50210(50210, "根据应用系统统计设备数量失败"),
    ERROR_CODE_50211(50211, "查询设备失败"),
    ERROR_CODE_50212(50212, "根据组织机构统计设备数量失败"),
    ERROR_CODE_50213(50213, "分配设备到应用系统失败"),
    ERROR_CODE_50214(50214, "根据应用系统查询默认组织机构信息失败"),
    ERROR_CODE_50215(50215, "根据父级组织查询下级组织信息失败"),
    ERROR_CODE_50216(50216, "根据设备类型统计设备数量失败"),
    ERROR_CODE_50217(50217, "根据设备ID查询设备信息失败"),
    ERROR_CODE_50218(50218, "设备ID参数错误"),
    ERROR_CODE_50219(50219, "检验设备的应用系统和组织机构对应关系失败"),
    ERROR_CODE_50220(50220, "修复设备的应用系统和组织机构对应关系开关未开启"),
    ERROR_CODE_50221(50221, "用户角色ID为空"),
    ERROR_CODE_50222(50222, "百羚应用系统标志位baiLingFlag为空"),
    ACCOUNT_PASSED(50223, "账号已过期"),
    ACCOUNT_EXPIRE(50224, "您的账号已过期，请联系管理员办理延长手续"),
    ERROR_CODE_50225(50225, "用户未分配应用系统,请联系管理员处理"),
    ERROR_CODE_50226(50226, "该账号被禁用,请联系管理员处理"),
    ERROR_CODE_50227(50227, "用户账号已过期,暂时无法使用，请联系管理员处理"),
    ERROR_CODE_50301(50301, "删除应用系统失败"),
    ERROR_CODE_50302(50302, "查询应用系统失败"),
    ERROR_CODE_50303(50303, "查询应用系统列表失败"),

    ERROR_CODE_50304(50304, "添加应用系统菜单失败"),
    ERROR_CODE_50305(50305, "删除应用系统菜单失败"),

    ERROR_CODE_50306(50306, "新建组织机构失败"),
    ERROR_CODE_50307(50307, "修改组织机构失败"),
    ERROR_CODE_50308(50308, "组织机构ID为空"),
    ERROR_CODE_50373(50373, "该组织编码已存在"),
    ERROR_CODE_50374(50374, "该组织编码已重复"),
    ERROR_CODE_50375(50375, "该组织存在下级组织"),
    ERROR_CODE_50376(50376, "该组织存在成员"),

    ERROR_CODE_50309(50309, "创建应用系统失败"),
    ERROR_CODE_50310(50310, "初始化应用系统菜单失败"),
    ERROR_CODE_50311(50311, "初始化应用系统组织机构失败"),
    ERROR_CODE_50312(50312, "初始化应用系统角色失败"),
    ERROR_CODE_50313(50313, "初始化应用系统管理员失败"),
    ERROR_CODE_50314(50314, "应用系统不存在"),
    ERROR_CODE_50315(50315, "修改应用系统失败"),
    ERROR_CODE_50316(50316, "组织机构不存在"),
    ERROR_CODE_50317(50317, "应用系统默认菜单配置项为空"),
    ERROR_CODE_50318(50318, "获取token失败 "),

    ERROR_CODE_50319(50319, "查询字段信息失败"),
    ERROR_CODE_50320(50320, "查询日志信息失败"),

    ERROR_CODE_50321(50321, "查询告警统计信息失败"),
    ERROR_CODE_50322(50322, "查询资源统计信息失败"),
    ERROR_CODE_50323(50323, "统计设备实时状态失败"),
    ERROR_CODE_50324(50324, "统计存储信息失败"),

    ERROR_CODE_50325(50325, "登录失败"),
    ERROR_CODE_50326(50326, "查询用户权限失败"),
    ERROR_CODE_50327(50327, "查询用户信息失败"),
    ERROR_CODE_50328(50328, "修改密码失败 "),
    ERROR_CODE_50329(50329, "登出失败"),
    ERROR_CODE_50330(50330, "修改用户失败"),
    ERROR_CODE_50331(50331, "删除用户失败"),
    ERROR_CODE_50332(50332, "新增用户失败"),
    ERROR_CODE_50333(50333, "根据组织机构查询用户失败"),
    ERROR_CODE_50334(50334, "查询用户角色失败"),
    ERROR_CODE_50335(50335, "删除角色失败"),
    ERROR_CODE_50336(50336, "新建角色失败"),
    ERROR_CODE_50337(50337, "编辑角色失败"),
    ERROR_CODE_50338(50338, "查询角色列表失败"),
    ERROR_CODE_50339(50339, "查询角色权限列表失败"),
    ERROR_CODE_50340(50340, "查询菜单权限列表失败"),
    ERROR_CODE_50341(50341, "查询用户微调权限失败"),

    ERROR_CODE_50342(50342, "发送手机验证码失败"),
    ERROR_CODE_50343(50343, "检验手机验证码失败"),

    ERROR_CODE_50344(50344, "查询用户信息失败"),
    ERROR_CODE_50345(50345, "重置用户密码失败"),

    ERROR_CODE_50346(50346, "查询设备信息失败 "),
    ERROR_CODE_50347(50347, "根据组织机构分组统计设备在线离线数量"),
    ERROR_CODE_50348(50348, "修改设备的组织机构失败"),
    ERROR_CODE_50349(50349, "修改设备的应用系统失败"),
    ERROR_CODE_50350(50350, "新增设备失败"),
    ERROR_CODE_50351(50351, "修改设备信息失败"),
    ERROR_CODE_50352(50352, "修改设备位置信息失败"),
    ERROR_CODE_50353(50353, "单兵设备注册失败"),
    ERROR_CODE_50354(50354, "绑定单兵设备失败"),
    ERROR_CODE_50355(50355, "单兵设备解绑失败"),
    ERROR_CODE_50356(50356, "查询用户绑定的单兵设备信息"),
    ERROR_CODE_50357(50357, "查询单兵设备信息失败"),
    ERROR_CODE_50358(50358, "设备状态统计失败"),
    ERROR_CODE_50359(50359, "设备导出失败"),
    ERROR_CODE_50360(50360, "获取所有模块列表失败"),
    ERROR_CODE_50361(50361, "删除组织机构失败"),
    ERROR_CODE_50362(50362, "查询组织机构失败"),
    ERROR_CODE_50363(50363, "根据用户查询组织机构失败"),

    ERROR_CODE_50364(50364, "保存日志信息失败"),
    ERROR_CODE_50365(50365, "检验设备信息失败 "),

    ERROR_CODE_50366(50366, "新增第三方接入信息失败"),
    ERROR_CODE_50367(50367, "更新第三方接入信息失败"),
    ERROR_CODE_50368(50368, "停用第三方接入信息失败"),
    ERROR_CODE_50369(50369, "单兵登陆失败"),
    ERROR_CODE_50370(50370, "查询操作端失败"),
    ERROR_CODE_50371(50371, "分配组织场所资源失败,场所在组织中不存在.请刷新后重试"),
    ERROR_CODE_50372(50372, "查询客户端ip失败"),

    /*工作流*/
    ERROR_CODE_COMMENT_ADD_WORKFLOW(600000,"增加指令评论失败！"),
    ERROR_CODE_COMMENT_USER_WORKFLOW(600001,"评论人ID不能为空！"),
    ERROR_CODE_COMMENT_DELETE_PARAM_EMPTY_WORKFLOW(600002,"参数不能全部为空！"),
    ERROR_CODE_COMMENT_DELETE_WORKFLOW(600003,"删除评论信息失败！"),
    ERROR_CODE_COMMENT_QUERY_WORKFLOW(600004,"获取评论信息失败！"),
    ERROR_CODE_COMMENT_UPDATE_WORKFLOW(600005,"修改评论信息失败！"),

    ERROR_NODE_DELETE_EMPTY(600006,"节点按钮参数不能为空！"),

    ERROR_FORM_TABLE_EXIST(61000,"表单名称已经存在！"),

    ERROR_FORM_TABLE_CREATE(61001,"创建表格失败！"),

    ERROR_FORM_TABLE_PAGE_QUERY(61002,"查询表单失败！"),

    ERROR_FORM_TABLE_UPDATE(61003,"修改表单失败！"),

    ERROR_FORM_TABLE_NAME_EXIST(61004,"表单名称已存在！"),

    ERROR_FORM_TABLE_ID_EMPTY(61005,"表单ID不能为空！"),

    ERROR_TABLE_TEMPLATE_DOWNLOAD(61006,"下载表单模板失败！"),

    ERROR_TABLE_DATA_ADD(61007,"增加表单数据失败！"),

    ERROR_TABLE_DATA_QUERY(61008,"查询表单数据失败！"),

    ERROR_EXCEL_IMPORT(61007,"excel数据解析失败！"),

    ERROR_DELETE_FORM_DATA(61008,"删除表单数据失败！"),

    ERROR_DELETE_FORM_UPDATE(61009,"修改表单数据失败！"),

    ERROR_DELETE_FORM_UPDATE_EMPTY(61010,"参数不正确,请检查参数是否存在！"),

    ERROR_EXCEL_EXPORT(610011,"excel导出失败！"),

    //错误码范围102001-103000
    ERROR_CODE_PARAM_ERROR(102001, "请求参数非法"),
    ERROR_CODE_USER_SYSTEM_ERROR(102002, "用户服务内部异常"),
    ERROR_CODE_USER_NOT_FOUND(102003, "用户名或密码错误!"),
    //ERROR_CODE_PASSWORD_ERROR(102004, "密码连续输错{total}次后，账户将被锁定{hour}小时。您还有{times}次尝试机会"),
    //飘柔注释了上面的代码，改为下面的提示，飘柔之后再恢复
    //ERROR_CODE_PASSWORD_ERROR(102004, "旧密码输入错误，请重试！"),
    ERROR_CODE_USER_EXPIRE(102005, "您的账号已过期，请联系管理员办理延长手续!"),
    ERROR_CODE_VERIFICATIONCODE_EXPIRE(102006, "验证码不存在或已过期，请重新输入"),
    ERROR_CODE_NAME_PASSWORD_IDENTIFYING_CDOE_REQUIRED(102007, "用户名，密码，验证码必填"),
    ERROR_CODE_NAME_PASSWORD_IDENTIFYING_REQUIRED(102007, "用户名，密码必填"),
    ERROR_CODE_NAME_PASSWORD_REQUIRED(102008, "用户名，密码必填"),
    ERROR_CODE_SEND_SMS_CODE_REQUIRED(102009, "短信验证码发送失败"),
    ERROR_CODE_DEVICE_NOT_NULL(102012, "组织下有设备不能删除"),
    ERROR_CODE_ID_NOT_SAME(102013, "请求参数id不一致"),
    ERROR_CODE_URL_UNMATCH_PARAM(102014, "URL地址与请求参数信息不一致"),
    ERROR_CODE_ROLE_DELETE_102015(102015, "中心角色信息不允许删除!"),
    ERROR_CODE_ROLE_DELETE_102016(102016, "当前角色正在被使用不允许删除!"),
    ERROR_CODE_ROLE_DELETE_ERROR(102017, "角色删除失败!"),
    ERROR_CODE_ROLE_NOT_FOUND(102018, "当前角色不存在!"),
    ERROR_CODE_ROLE_DUPLICATE(102019, "角色名称已经存在!"),
    ERROR_CODE_ROLE_ADD_ERROR(102020, "角色新增失败!"),
    ERROR_CODE_ROLE_UPDATE_ERROR(102021, "角色修改失败!"),
    ERROR_CODE_USER_QUERY_ERROR(102022, "查询用户失败"),
    ERROR_CODE_USER_UPDATE_ERROR(102023, "修改用户失败"),
    ERROR_CODE_USER_DELETE_ERROR(102024, "删除用户失败"),
    ERROR_CODE_USER_NAME_DUPLICATE(102025, "用户名已存在"),
    ERROR_CODE_USER_SOLO_DEVICE_EXIST(102026, "该用户已绑定单兵设备，请进行解绑后删除"),
    ERROR_CODE_102027(102027, "收藏失败"),
    ERROR_CODE_102028(102028, "请勿重复收藏"),
    ERROR_CODE_102029(102029, "删除收藏失败"),
    ERROR_CODE_102030(102030, "获取用户收藏列表失败"),
    ERROR_CODE_LOCK(102031, "账号被锁定，请于%s 时之后再重新登录"),

    ERROR_CODE_OPERATION_CENTER_QUERY_ERROR(102031, "运营中心查询异常"),
    ERROR_CODE_OPERATION_CENTER_ID_ERROR(102031, "查询的运营中心编号不能为空"),
    ERROR_CODE_OPERATION_CENTER_NOT_FOUND(102032, "运营中心不存在"),
    ERROR_CODE_OPERATION_CENTER_UPDATE_ERROR(102033, "修改运营中心失败"),
    ERROR_CODE_OPERATION_CENTER_DELETE_ERROR(102034, "删除运营中心失败"),
    ERROR_CODE_OPERATION_CENTER_MENU_UPDATE_ERROR(102035, "修改运营中心菜单失败"),
    ERROR_CODE_OPERATION_CENTER_PLACE_QUERY_ERROR(102036, "查询运营中心场所数量异常"),
    ERROR_CODE_ORGANIZATION_QUERY_ERROR(102037, "根据运营中心查询默认组织机构信息失败"),
    ERROR_CODE_102038(102038, "创建运营中心失败"),
    ERROR_CODE_PARENT_ID_ERROR(102039, "parentId不能等于自己id"),

    ERROR_CODE_102040(102040, "删除组织机构失败"),
    ERROR_CODE_102041(102041, "新增视频标注失败"),
    ERROR_CODE_OPOERATION_CENTER_ERROR(102042, "用户运营中心无效或不存在!"),
    ERROR_CODE_USER_LOGIN_ERROR(102043, "用户登陆失败!"),
    ERROR_CODE_USER_ADD_ERROR(102044, "新增用户失败"),
    ERROR_CODE_102045(102045, "您输入的验证码错误"),
    ERROR_CODE_102046(102046, "加密公钥错误"),
    ERROR_CODE_USER_MONITOR_LIBS_OR_TASKS_EXIST(102047, "该用户有创建的布控库或布控任务，无法由别人删除，请删除布控库和布控任务后再删除用户！"),
    ERROR_CODE_QUERY_MONITOR_LIBS_WHEN_DELETE_USER(102048, "删除用户时，查询用户创建的布控库信息失败！"),
    ERROR_CODE_QUERY_MONITOR_TASKS_WHEN_DELETE_USER(102049, "删除用户时，查询用户创建的布控任务信息失败！"),
    ERROR_CODE_NOTEXIST_SYSTEM_DEFAULT_PASSWORD(102050, "系统未设置默认密码"),

    ERROR_CODE_EMPTY_PARAM(102051, "参数[%s]不能为空！"),
    ERROR_CODE_INVALID_PARAM(102052, "参数[%s]不合法，[%s]！"),
    ERROR_CODE_NO_CANDIDATE_REVIEWERS(102053, "您的同级或上级都没有下载审批权限！"),
    ERROR_CODE_NOT_ALLOWED_MODIFY_APPLY(102054, "只能修改待审核的申请！"),
    ERROR_CODE_REVIEWSTATUS_IS_FINAL(102055, "审批状态已经是终态，不允许再修改！"),
    ERROR_CODE_INVALID_RESOURCE(102056, "资源不存在"),
    ERROR_CODE_VIDEO_CANNOT(102057, "视频资源不允许批量下载"),
    ERROR_CODE_NO_REVIEW_PRIVILEGE(102058, "您没有对该申请进行审批的权限！"),
    ERROR_CODE_RESOURCE_EXPIRED(102059, "资源已过期！"),
    ERROR_CODE_DOWNLOAD_FAIL(102060, "下载图片zip包失败"),
    ERROR_CODE_QUERY_DOWNLOAD_RESOURCES_FAIL(102061, "查询资源信息失败！"),
    ERROR_CODE_CHECK_PASSWORD_FAIL(102062, "密码检验失败！"),
    ERROR_CODE_LOGIN_NAME_REQUIRED(102063, "用户名必填"),
    ERROR_CODE_USER_NOT_STATUS(102064, "用户不存在或状态为无效用户"),
    ERROR_CODE_UN_VALID(102065, "用户被禁用，请联系管理员处理"),
    ERROR_CODE_USER_LOCKED(102066, "用户被锁定，请联系管理员处理"),

    ERROR_CODE_USER_NOT_REGISTER(102077, "用户未注册，请先注册账户！"),
    ERROR_CODE_USER_IDENTIFYING_CDOE(102067, "验证码输入错误"),
    ERROR_CODE_USER_PHONE_AND_PWD(102068, "请输入正确的手机号（账号）或密码"),
    ERROR_CODE_USER_ALREADY_EXIST(102069, "手机号已注册"),
    ERROR_CODE_USER_FORGET_PWD(102070, "用户不存在或用户信息填写错误"),
    ERROR_CODE_USER_CREATE(102071, "注册用户失败"),
    ERROR_CODE_USER_ADD_COMPANY_INFO(102072, "录入个人信息/企业信息失败"),
    ERROR_CODE_USER_UPDATE_USER_INFO(102073, "更新个人信息失败"),
    ERROR_CODE_USER_UPDATE_COMPANY_INFO(102074, "更新企业信息失败"),
    ERROR_CODE_USER_CHANGE_BIND_PHONE(102075, "换绑手机号失败"),
    ERROR_CODE_USER_CHANGE_FORGET_PWD_PHONE(102076, "修改密码失败"),
    ERROR_CODE_VILLAGE_NOT_NULL(102077, "组织下有小区不能删除"),
    ERROR_CODE_PRIVATE_PARSE_PWD(102077, "私钥解密失败"),
    ERROR_CODE_RESOURCE_EXIST_ERROR(102101, "资源已存在，不能重复添加"),
    ERROR_CODE_ADD_RESOURCE_ERROR(102101, "资源添加失败"),
    ERROR_CODE_PATH_BODY_ID_DIFFERENT_ERROR(102102, "请求地址中id与请求体中id不相等"),
    ERROR_CODE_DELETE_RESOURCE_ERROR(102103, "删除资源失败"),
    ERROR_CODE_UPDATE_RESOURCE_ERROR(102104, "更新资源失败"),
    ERROR_CODE_ADD_PRIVILEGE_ERROR(102105, "新增权限失败"),
    ERROR_CODE_DELETE_PRIVILEGE_ERROR(102105, "删除权限失败"),
    ERROR_CODE_ADD_MENU_ERROR(102106, "新增菜单失败"),
    ERROR_CODE_MENU_NOT_EXIST_ERROR(102106, "菜单不存在"),
    ERROR_CODE_DELETE_MENU_ERROR(102106, "删除菜单失败"),
    ERROR_CODE_ADD_MODULE_ERROR(102107, "新增模块失败"),
    ERROR_CODE_MODULE_NOT_EXIST_ERROR(102107, "模块不存在"),
    ERROR_CODE_SCENE_NOT_EXIST_ERROR(102108, "场景不存在"),
    ERROR_CODE_SCENE_BIND_OPERATION_ERROR(102109, "删除场景失败,该场景类型被运营中心绑定"),
    LOGIN_DEVICE_IS_CHANGED(50100, "登录设备发生变更,请进行手机动态验证"),
    ERROR_PERSON_DUPLICATE(509000, "人员重复"),
    ERROR_LINK_URL_DUPLICATE(509001, "链接已存在！"),
    ERROR_CODE_DATA_NOT_FOUND(50101, "数据不存在"),
    ERROR_HAS_BIND(50102, "该链接已绑定账户密码"),
    ERROR_LINK_URL_NOT_EXIST(509002, "链接已存在！"),
    ERROR_CODE_NAME_OR_PHONE_EXISTS(509003, "用户登录名称或手机号已存在！"),
    ERROR_INTERFACE_RESOURCE_EXISTS(509004, "接口资源已存在"),
    ERROR_IMPORT(509005, "导入接口资源失败"),


    ERR_CODE_OK(999999, "成功"),
    //密码验证
    ERR_CODE_MISS_PWD(201000, "密码缺失为空"),
    ERR_CODE_ERROR_PWD(201001, "密码错误"),
    ERR_CODE_EXPIRE_PWD(201002, "密码已过期"),
    ERR_CODE_ACCESS_DENIED(201003, "不允许访问系统"),
    ERR_CODE_IP_ACCESS_DENIED(201004, "此登录IP不允许访问系统"),
    ERR_CODE_WEEK_PWD(201005, "密码强度较弱"),
    ERR_CODE_RESET_PWD(201006, "密码即将过期，请重置"),
    //ip检测
    ERR_CODE_ACCESS_LOGIN_IP(201101, "此登录IP不在允许范围内"),
    ERR_CODE_NOT_ALLOW_PWD_LOGIN(201100, "此账号不允许密码登录"),
    ERR_CODE_ACCESS_LOGIN_PWD_IP(201102, "登录IP不在允许密码登录IP范围内"),
    //账号验证
    ERR_CODE_USER_LOCKED(201103, "密码错误次数已达上限，账户已被锁定"),
    ERR_CODE_USER_STATUS_LOCKED(201104, "账户已被锁定"),
    ERR_CODE_USER_STATUS_DELETED(201105, "账户已被删除"),
    ERR_CODE_USER_INVALID(201106, "账户已过有效期"),
    ERR_CODE_USER_NOT_VALID(201107, "账户未达到有效期"),
    ERR_CODE_LOGIN_EXPIRED(201108, "登录已过期"),
    ERR_CODE_LOGIN_NAME_EXIST(201109, "账户已存在，待激活"),
    ERR_CODE_INVALIDSIGNA_TURE(201110, "用户验证不通过"),
    ERR_CODE_PHONENUMBER_INVALID(201111, "手机号不正确"),
    ERR_CODE_SMSCHECK_TIME_FAILED(201112, ""),
    ERR_CODE_SMSCHECK_IP_FAILED(201113, ""),
    ERR_CODE_GET_CACHE_FAILED(201114, ""),

    CODE_PARAM_NULL(40004, "输入参数为空"),

    ERR_CODE_SESSION_GET_FAILED(202000, "获取session失败"),
    ERR_CODE_SESSION_ADD_FAILED(202001, "创建session失败"),
    ERR_CODE_SESSION_DELETE_FAILED(202002, "创建session失败"),
    ERR_CODE_LOGIN_FAILED(202003, "登录失败"),
    ERR_CODE_LOGIN_USER_FAILED(202004, "获取登录用户信息失败"),
    ERR_CODE_WEB_SOCKET_FAILED(202005, "websocket"),

    ERR_CODE_TOKEN_MISSING(203000, "token丢失"),
    ERR_CODE_TOKEN_DECODE_FAILED(203001, "token格式无效"),
    ERR_CODE_TOKEN_ACCESS_EXPIRED(203002, "token已过有效期"),
    ERR_CODE_TOKEN_INVALID(203003, "token无效"),
    ERR_CODE_TOKEN_MISMATCH(203004, "当前登录用户token无效"),
    ERR_CODE_TOKEN_ENCODE_FAILED(203005, "token解析失败"),
    ERR_CODE_TOKEN_CACHED_FAILED(203006, "增加token缓存失败"),
    ERR_CODE_TOKEN_EXPIRED(203007, "token失效"),

    ERR_CODE_GET_USER_FAILED(241000, "获取用户信息失败"),
    ERR_CODE_UPDATE_USER_FAILED(241001, "获取用户信息失败"),

    ERR_CODE_GET_USER_ROLE_FAILED(242000, "获取用户角色信息失败"),

    ERR_CODE_GET_ROLE_FAILED(243000, "获取角色信息失败"),

    ERR_CODE_NOT_FOUND(242001, "查询内容不存在"),
    ERR_CODE_NOT_SUPPORTED(245002, "服务无响应"),

    ERR_CODE_BAD_REQUEST(244000, "参数错误"),
    ERR_CODE_SERVER_ERROR(245000, "服务器错误"),

    ERR_CODE_READ_FILE_FAILED(243000, "读取文件失败"),
    ERR_CODE_UPLOAD_FILE_FAILED(243001, "文件上传失败"),
    ERR_CODE_READ_UPLOAD_FILE_FAILED(243002, "读取文件失败"),
    ERR_CODE_CREATE_FILE_FAILED(243003, "读取文件失败"),
    ERR_CODE_FORMAT_JSON_FAILED(243004, "json格式话失败"),
    ERR_CODE_DB(246001, "操作数据失败"),
    //人像平台消息码
    ERR_CODE_GET_SYS_CONFIG_FAILED(246001, "获取配置信息失败"),
    ERR_CODE_GET_API_INTERFACE_FAILED(246002, "获取接口信息失败"),
    ERR_CODE_GET_FACE_DOSSIER_FAILED(246010, "获取人像平台基本信息失败"),
    ERR_CODE_GET_PORTRAIT_PLATFORM_FAILED(246003, "获取人像平台信息失败"),
    ERR_CODE_REQUEST_PLATFORM_FAILED(246004, "调用人像平台接口失败"),
    ERR_CODE_FORMAT_REQUEST_PLATFORM_FAILED(246005, "调用人像平台接口失败"),
    ERR_CODE_LOGIN_PLATFORM_FAILED(246006, "登录人像平台失败"),
    ERR_CODE_IMG_SEARCH_PLATFORM_FAILED(246007, "人像平台图搜接口报错"),
    ERR_CODE_RESPONSE_PLATFORM_FAILED(246008, "人像平台接口返回结果无效"),

    ERR_CODE_DETEATCH_FAILED(246009, "人像平台图片特征值提取失败"),
    ERR_CODE_HANA_XSJS_FAILED(246011, "hanaxsjs接口错误"),
    ERR_CODE_CAMERA_GET_FAILED(246010, "获取人像摄像头列表失败"),
    ERR_CODE_REQUEST_FAILED(246020, "照片和身份证必须有一个不能为空"),
    ERR_CODE_CAMERA_NOT_EMPTY_FAILED(246013, "摄像头不能为空"),

    ERR_CODE_API_NOT_EXIST_FAILED(246014, "接口地址错误"),
    ERR_CODE_NOT_AUTH_HANA(246015, "hanaxsjs接口错误"),
    //接口注册消息码
    ERR_CODE_API_INTERFACE_COLUMN_FAILED(246012, "注册接口文档关键字段不能为空"),
    ERR_CODE_API_INTERFACE_COLUMN_IN_VALID(246018, "注册接口文档关键字段不能为空"),
    ERR_CODE_API_INTERFACE_INFO_FAILED(246013, "注册接口文档模板错误"),
    ERR_CODE_API_INTERFACE_FAILED(246016, "注册接口文档模板错误"),
    ERR_CODE_ICON_SYMBOL_MATCH_FAILED(246017, "注册接口文档模板错误"),
    ERR_CODE_FUNCTION_PARAMS_MATCH_FAILED(247001, "函数参数个数不匹配"),
    ERR_CODE_API_INTERFACE_TYPE_NAME(250003, "接口业务分类不存在"),
    ERR_CODE_API_INTERFACE_DOC_INVALID(250005, "接口文档格式不正确"),
    //图标库消息码code
    ERR_CODE_ICON_NAME_LENGTH_FAILED(248001, "图标名称在30个汉字以内"),
    ERR_CODE_ICON_SYBOL_LENGTH_FAILED(248002, "图标英文名称在30个汉字以内"),
    ERR_CODE_USER_LOG_EVENT_FAILED(248003, "图标英文名称在30个汉字以内"),
    ERR_CODE_ICON_FILE_EXT_FAILED(248004, "图标附件格式不正确"),
    ERR_CODE_ICON_BODY_FAILED(248005, "图标附件内容格式错误"),
    ERR_CODE_ICON_NAME_IS_NOT_EMPTY(248006, "图标中文名称不能为空"),
    //功能模块消息吗
    ERR_CODE_GET_MODULE_FAILED(248100, "获取功能模块失败"),
    //全文检索
    ERR_CODE_SEARCH_SQL_CHECK_FAILED(249000, "字段生成的SQL失败"),
    ERR_CODE_SEARCH_SQL_FORMAT_FAILED(249001, "全文检索sql校验失败"),
    ERR_CODE_SEARCH_TABLE_SYNC_FAILED(249002, "同步配置表信息失败"),
    ERR_CODE_SEARCH_CONFIG_FAILED(249003, "获取服务器配置信息失败"),
    ERR_CODE_SEARCH_TABLE_COLUMN_DIC_FAILED(249004, "获取字段字段信息失败"),
    ERR_CODE_SEARCH_TABLE_COLUMN_GET_FAILED(249005, "获取字段字段信息失败"),
    ERR_CODE_SEARCH_TABLE_ADD_FAILED(249006, "增加表配置信息失败"),
    ERR_CODE_SEARCH_TABLE_GET_FAILED(249007, "获取表配置信息失败"),
    ERR_CODE_DATA_BASE_CONNECT_FAILED(249008, "数据库无法连接"),
    ERR_CODE_DATA_BASE_IN_VALID(249009, "数据库不可用"),
    ERR_CODE_SCHEMA_CONF_GET_FAILED(249010, "数据库配置信息获取失败"),
    ERR_CODE_TABLE_LIST_FAILED(249011, "获取表清单失败"),
    //批量轨迹比对
    ERR_CODE_TRAVEL_COLUMN_GET_FAILED(249100, "获取配置字段信息失败"),
    ERR_CODE_TRAVEL_TABLE_GET_FAILED(249101, "获取表配置信息失败"),

    ERR_CODE_CITIZEN_SOURCE_FAILED(249201, "图片路径不正确"),
    ERR_CODE_CITIZEN_IMAGE_FAILED(249202, "图片路径不正确"),

    //流程状态不正确
    ERR_CODE_INSTANCE_STATS_FAILED(800000,"流程状态不正确，请刷新后重试"),
    ERR_CODE_TRANSFER_PERSON_STATS_FAILED(800001,"转交人员名单不能为空！"),

    ERR_CODE_TRANSFER_ID_NOT_EMPTY(800002,"流程实例ID不能为空！"),

    ERR_CODE_ACCESS_DEPART_NOT_EMPTY(800003,"流程接收单位不能为空！");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
