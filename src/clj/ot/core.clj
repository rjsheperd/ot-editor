(ns ot.core
  (:require [othello.store :as store]
            [othello.operations :as op :refer [defops]]
            [othello.documents :as docs])
  (:import [java.util UUID]))

(def doc (atom "ram"))

(def change (defops ::op/ret 1 ::op/ins "o" ::op/ret 2 ::op/in "!"))

(swap! @doc docs/apply-ops change)

(swap! doc conj (store/operation (defops ::op/ret 1 ::op/ins "o") :id (UUID/randomUUID)))

@doc

(store/as-string @doc)
