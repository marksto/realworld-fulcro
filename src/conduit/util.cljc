(ns conduit.util)

(defn get-ident
  [x]
  (ffirst x))

(defn get-item
  [x]
  (second (first x)))

(comment
  (get-ident {[:user/by-id 19] #:user{:bio "some text"}})
  ;; => [:user/by-id 19]
  (get-item {[:user/by-id 19] #:user{:bio "some text"}})
  ;; => #:user{:bio "some text"}#:user{:bio "some text"}
)

(defn remove-namespace [namespace ks]
  (into {}
    (for [k ks]
      [(keyword namespace (name k)) k])))

(defn page-number [total items-per-page]
  (if (zero? total)
    1
    (+ (quot total items-per-page)
      (if (zero? (rem total items-per-page))
        0
        1))))
