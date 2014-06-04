(ns visitor.benchmark.test)


(defprotocol Bob
  (bob [item]))


(extend-type
    Object
  Bob
  (bob [item] "object"))

(extend-type
    Number
  Bob
  (bob [item] "number"))

(extend-type
    Integer
  Bob
  (bob [item] "integer"))


(bob (Object.))
(bob (Integer. 1))


(defprotocol Fred
  (fred [item]))

(extend-type CharSequence
  Fred
  (fred [item] "charseq"))

(extend-type Comparable
  Fred
  (fred [item] "comparable"))

(extend-type java.io.Serializable
  Fred
  (fred [item] "serializable"))


(fred "hello")
