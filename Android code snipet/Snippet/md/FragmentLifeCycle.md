# Fragment lifecycle

[](http://i.stack.imgur.com/fRxIQ.png)

**Fragment lifecycle have 11 methods**

```java
onAttach()
onCreate()

onCreateView()
onActivityCreated()
onStart()
onResume()
onPause()
onStop()
onDestroyView();

onDestroy()
onDetach();
```

--------------------------------------------------------------------------------

## onAttach():

Construct fragment class but not hold view and no information anymore. It's just class in memory.

## onCreate():

New fragment instance but not hold view.

## onViewCreate():

Inflate xml to View that hold by fragment and return view to show.

## onActivityCreated():

View is created in Activity completely. Fragment can communicate with Activity from now on.

## onDestroyView():

Destory view that hold but not destroy fragment.
