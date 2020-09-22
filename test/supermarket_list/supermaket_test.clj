(ns supermarket-list.supermaket-test
  (:require [clojure.test :refer :all]
            [supermarket-list.supermarket :as sm]))

(defn setup []
  (println "setup"))

(defn teardown []
  (println "teardown")
  (sm/remove-all!))

(use-fixtures :each
              (fn [tests]
                (setup)
                (tests)
                (teardown)))

(deftest test-can-add-item
  (let [item {:name "Rice" :quantity 1 :price 8.99M}]
    (sm/add-item! item)
    (println (deref sm/supermarket))
    (is (= (get (filterv (fn [v] (= (:name item) (:name v))) (deref sm/supermarket)) 0) item))))


(deftest test-can-remove-item-by-name
  (sm/add-item! {:name "Sugar" :quantity 2 :price 4.67M})
  (sm/add-item! {:name "Juice" :quantity 1 :price 10.55M})
  (sm/add-item! {:name "Beans" :quantity 3 :price 8.33M})
  (println (deref sm/supermarket))
  (sm/remove-item-by-name! "Juice")
  (println (deref sm/supermarket))
  (is (true? (empty? (filter (fn [item] (= (:name item) "Juice")) (deref sm/supermarket))))))









