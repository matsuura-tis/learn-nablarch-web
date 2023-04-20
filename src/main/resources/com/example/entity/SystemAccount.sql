--------------------------------------------------------------------------------
-- 利用可能なシステムアカウント情報を取得するSQL
--------------------------------------------------------------------------------
FIND_SYSTEM_ACCOUNT =
SELECT
  *
FROM
  SYSTEM_ACCOUNT
WHERE
  LOGIN_ID = ?
  AND ? BETWEEN EFFECTIVE_DATE_FROM AND EFFECTIVE_DATE_TO

--------------------------------------------------------------------------------
-- ログインIDからシステムアカウントを取得する
--------------------------------------------------------------------------------
FIND_SYSTEM_ACCOUNT_BY_LOGIN_ID =
SELECT
  *
FROM
  SYSTEM_ACCOUNT
WHERE
  LOGIN_ID = :loginId
