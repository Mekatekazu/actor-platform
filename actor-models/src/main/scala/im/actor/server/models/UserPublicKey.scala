package im.actor.server.models

@SerialVersionUID(1L)
case class UserPublicKey(
  userId: Int,
  hash: Long,
  data: Array[Byte]
)
