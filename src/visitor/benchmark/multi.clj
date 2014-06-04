(ns visitor.benchmark.multi
  (:use [visitor.benchmark.bench]
        [visitor.benchmark.onto]))

(defmulti multi class)

(defmethod multi org.semanticweb.owlapi.model.OWLClass [e])
(defmethod multi org.semanticweb.owlapi.model.OWLObjectProperty [e])


(defn multi-on-class []
  (bench (multi AClass)))

(defn multi-on-property []
  (bench (multi AProperty)))



(defn multi-on-class2 []
  (bench (multi AClass)))

(defn multi-on-property2 []
  (bench (multi AProperty)))

(defn run []
  (println "\nTesting Multimethods")
  (multi-on-class)
  (multi-on-property)
  (println "\nAnd after adding loads of methods")

  (load "visitor/benchmark/multi_more")
  (multi-on-class2)
  (multi-on-property2))
