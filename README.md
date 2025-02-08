# 宠物领养平台

# 数据库设计

## 1. `announcement` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| announcement_id | bigint    | 公告ID     |
| title          | varchar(255) | 标题       |
| content        | text        | 内容       |
| publish_time   | datetime    | 发布时间   |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 公告表，记录网站的公告信息，包括标题、内容、发布时间等。

## 2. `dictionary` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| dictionary_id  | bigint      | 字典ID     |
| name           | varchar(255) | 字典名称   |
| description    | varchar(255) | 字典描述   |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 字典表，用于存储应用程序中的字典项，提供基础数据支持。

## 3. `dictionary_item` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| item_id        | bigint      | 字典项ID   |
| dictionary_id  | bigint      | 字典ID     |
| value          | varchar(255) | 字典项的值 |
| label          | varchar(255) | 字典项标签 |
| sort_order     | int         | 排序字段   |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 字典项表，存储每个字典的具体条目，如状态、类型等。

## 4. `forum_post` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| post_id        | bigint      | 帖子ID     |
| image          | varchar(255) | 图片路径   |
| title          | varchar(255) | 标题       |
| user_id        | bigint      | 用户ID     |
| content        | longtext    | 内容       |
| publish_time   | date        | 发布时间   |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 论坛帖子管理表，记录用户发布的帖子信息，包含标题、内容等。

## 5. `pet_adopt_application` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| application_id | varchar(50) | 申请编号   |
| user_id        | bigint      | 用户ID     |
| pet_id         | bigint      | 宠物ID     |
| apply_time     | date        | 申请时间   |
| status         | varchar(20) | 申请状态   |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 宠物申请管理表，用于记录用户申请领养宠物的详细信息。

## 6. `pet_breed` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| breed_id       | bigint      | 品种ID     |
| breed          | varchar(255) | 品种名称   |

**表备注**: 宠物品种表，记录所有宠物品种的详细信息。

## 7. `pet_info` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| pet_id         | bigint      | 宠物ID     |
| image          | varchar(255) | 图片路径   |
| breed_id       | bigint      | 品种ID     |
| category       | varchar(10)  | 分类       |
| color          | varchar(50)  | 颜色       |
| gender         | varchar(2)   | 性别       |
| weight         | varchar(20)  | 体重       |
| birthday       | date         | 生日       |
| health_status  | varchar(255) | 健康状况   |
| training       | varchar(255) | 训练情况   |
| adopt_conditions | text       | 领养条件   |
| personality    | text        | 性格特点   |
| adopt_history  | text        | 领养历史   |
| description    | text        | 简介       |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 宠物信息表，记录宠物的详细资料，包括品种、性别、健康状况、领养条件等。

## 8. `product_info` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| product_id     | bigint      | 商品ID     |
| name           | varchar(255) | 商品名称   |
| image          | varchar(255) | 商品图片路径 |
| price          | double      | 商品单价   |
| stock          | int         | 商品库存   |
| description    | text        | 商品简介   |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 商品信息表，记录商品的详细资料，包括价格、库存、简介等。

## 9. `product_order` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| order_code     | varchar(50) | 订单编号   |
| user_id        | bigint      | 用户ID     |
| product_id     | bigint      | 商品ID     |
| order_time     | date        | 下单时间   |
| status         | varchar(20) | 货物状态   |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 商品订单管理表，记录用户的商品购买订单，包括商品、状态、订单时间等。

## 10. `sys_user_info` 表
| 字段名         | 类型        | 描述       |
|----------------|-------------|------------|
| user_id        | bigint      | 用户ID     |
| nick_name      | varchar(255) | 昵称       |
| email          | varchar(255) | 邮箱       |
| password       | varchar(255) | 密码       |
| phone          | varchar(20)  | 手机号     |
| avatar         | varchar(255) | 头像路径   |
| user_type      | varchar(1)   | 用户类型   |
| updated_by     | bigint      | 更新人     |
| updated_at     | datetime    | 更新时间   |
| remarks        | text        | 备注       |
| is_deleted     | varchar(2)  | 是否删除   |
| deleted_by     | bigint      | 删除人     |
| deleted_at     | datetime    | 删除时间   |

**表备注**: 用户信息表，存储用户的基本信息，包括昵称、邮箱、密码、用户类型等。

# 宠物领养平台功能设计

## 主页 (Home)

主页是平台的入口，包含核心模块和快捷入口。

### 导航栏 (Navigation Bar)
- **主页**
- **宠物领养**
- **商店**
- **论坛**
- **个人中心**

### 功能模块
- **宠物领养**：展示待领养宠物，用户可以申请领养。
- **公告**：展示平台的最新公告和活动信息。
- **宠物商店**：展示商店热销商品或新品，用户可以进行购买。
- **论坛板块**：展示论坛热门话题和文章，用户可以参与讨论。

---

## 宠物领养 (Pet Adoption)

### 功能：
1. **宠物展示**：展示待领养的宠物信息（图片、品种、年龄、性别、健康状况等）。
2. **申请领养**：用户可以填写领养申请，提供个人信息和领养理由。
3. **申请审核**：发布者审核领养申请，审核通过后自动通知申请者。
4. **推送通知**：通过邮箱和平台内消息推送申请状态（通过、拒绝、待审核）。
5. **申请历史**：用户可以查看自己提交过的领养申请及状态。

---

## 商店 (Store)

### 功能：
1. **商品管理**：商家或管理员可以添加、修改、删除商品信息。
2. **商品展示**：展示商店的商品，包括价格、库存、图片等。
3. **订单管理**：用户下单后，商家管理订单状态（待发货、已发货、已送达等）。
4. **促销活动**：管理员发布商品的促销活动或优惠打折信息。
5. **商品评价**：用户可对购买的商品进行评价，帮助其他用户选择。

---

## 论坛 (Forum)

### 功能：
1. **文章发布**：用户可以自由发布文章，分享宠物经验或讨论话题。
2. **评论与点赞**：用户可以评论和点赞文章，促进互动。
3. **文章分类**：根据话题（如“宠物健康”，“领养故事”等）进行分类。
4. **热门话题**：展示当前热门的帖子，提升平台活跃度。
5. **举报与管理**：管理员可删除不符合社区规范的文章，确保平台秩序。

---

## 公告 (Announcement)

### 功能：
1. **公告发布**：管理员可以发布平台公告（系统更新、活动通知等）。
2. **公告分类**：公告按类型（如“活动通知”，“系统维护”等）分类。
3. **公告推送**：公告发布后，平台用户可收到通知推送或邮件提醒。

---

## 个人中心 (User Center)

### 功能：
1. **个人信息修改**：用户可修改邮箱、手机号、头像、密码等个人信息。
2. **我的申请**：查看提交的领养申请、订单记录、发帖记录等。
3. **我的消息**：展示系统消息、评论回复、订单更新等通知。
4. **安全设置**：用户可以修改密码、绑定邮箱/手机号等账户安全设置。

---

## 其他优化建议

### 用户交互体验：
1. **通知中心**：在个人中心增加通知中心，集中展示平台通知、申请状态、订单信息等。
2. **搜索与筛选**：在宠物领养、商店、论坛等模块提供搜索与筛选功能，方便用户快速找到感兴趣内容。
3. **收藏与分享**：允许用户收藏心仪的宠物或商品，方便后续查看，支持分享功能。

### 用户权限控制：
1. **管理员功能**：确保管理员在商店、论坛、公告管理等模块有管理权限，普通用户无法干预。
2. **用户验证**：对于修改个人信息、发帖、申请领养等敏感操作，增加验证码、邮箱验证等安全机制。

### 响应式设计：
确保平台在不同设备（手机、平板、电脑）上都能良好显示和使用。

---
