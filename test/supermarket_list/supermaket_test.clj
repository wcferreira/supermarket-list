(ns supermarket-list.supermaket-test
  (:require [clojure.test :refer :all]
            [supermarket-list.supermarket :as sm]))

(defn setup []
  (println "setup"))

(defn teardown []
  (println "teardown")
  (sm/remove-all!))

(use-fixtures :once
              (fn [tests]
                (setup)
                (tests)
                (teardown)))

(deftest test-can-add-item
  (let [item {:name "Rice" :quantity 1 :price 8.99M}]
    (sm/add-item! item)
    ;(println (deref sm/supermarket))
    (is (= (get (filterv (fn [v] (= (:name item) (:name v))) (deref sm/supermarket)) 0) item))))









