(ns supermarket-list.supermarket)

(def supermarket (atom []))


(defn add-item!
  [item]
  (swap! supermarket conj item))

(defn remove-all!
  []
  (println "======= remove-all! =======")
  (println @supermarket)
  (println "===========================")
  (reset! supermarket []))

(defn remove-item-by-name!
  [name]
  (swap! supermarket #(remove (fn [item] (= (:name item) name)) %)))

