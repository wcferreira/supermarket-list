(ns supermarket-list.supermarket)

(def supermarket (atom []))


(defn add-item!
  [item]
  (swap! supermarket conj item))

