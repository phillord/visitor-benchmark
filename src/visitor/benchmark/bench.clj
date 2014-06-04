(ns visitor.benchmark.bench
  (:require [criterium.core]))


(def bench-form
  ;;'clojure.core/time
  ;;'criterium.core/quick-bench
  'criterium.core/bench
  )

(defmacro bench [form]
  `(do
     (println "Benching:" (quote ~form))
     (~bench-form ~form)))
