# Spring-boot Scheduled 排程
### cron 表達式
1. 組成規則
- 每個時間單位都需用空格隔開
`秒 分 時 日 月 星期 年`

2. 詳細規則

| 時間單位 | 參數範圍 | 允許的特殊符號 |
| --------------- | --------------- | --------------- |
| 秒  | 0~59 整數 |` , - * /`  |
| 分  | 0~59 整數 | ` , - * /`  |
| 時  | 1~31 or 1~30 整數 (2月須注意) | ` , - * /`  |
| 日  | 0~23 整數 | `,- * ? / L W C `  |
| 月  | 1~12 整數 或是 JAN-DEC | ` , - * /`  |
| 星期  | 1~7 整數 或是 SUN-SAT | ` , - * ? / L C # `  |
| 年 (可為空)  | 0~59 整數 | ` , - * /`  |

3. 常用符號規則
- `*` -> 表示任何數字，ex:使用在秒，就會每秒觸發
- `?` -> 只能用在天與星期，ex:只想在每個月的1號觸發，而且不管他是禮拜幾 `12 12 12 1 * ?`，星期則需要用`?`表達，如果用`*`會每個星期觸發
- `-` -> 表示時間範圍，ex:只想在平日觸發，`12 12 12 * * 1-5`
- `/` -> 開始時間/時間間隔，ex:早上四點開始每隔兩個小時觸發，`12 12 4/2 * * *`
- `,` -> 時間陣列，ex:每天凌晨與正中午觸發`0 0 0,12 * * *`

[回首頁](https://github.com/LINDuke-Lin/Spring-Boot-Timmer-Demo#spring-boot-timmer-demo)