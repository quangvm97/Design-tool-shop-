package user

import scalikejdbc._
import org.joda.time.DateTime

case class UserRecord(
  id: Long,
  name: String,
  email: String,
  password: String)

object UserRecord extends SQLSyntaxSupport[UserRecord] {
  override val tableName = "user"

  def apply(c: SyntaxProvider[UserRecord])(rs: WrappedResultSet): UserRecord = apply(c.resultName)(rs)

  def apply(c: ResultName[UserRecord])(rs: WrappedResultSet): UserRecord = UserRecord(
    id = rs.long(c.id),
    name = rs.string(c.name),
    email = rs.string(c.email),
    password = rs.string(c.password))
}
