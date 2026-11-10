using UnityEngine;
using UnityEngine.InputSystem;

public class NewBehaviourScript : MonoBehaviour
{
    public float velocidad = 5f;

    void Update()
    {
        var keyboard = Keyboard.current;

        if (keyboard.wKey.isPressed)
            transform.Translate(Vector3.forward * velocidad * Time.deltaTime);

        if (keyboard.sKey.isPressed)
            transform.Translate(Vector3.back * velocidad * Time.deltaTime);

        if (keyboard.aKey.isPressed)
            transform.Translate(Vector3.left * velocidad * Time.deltaTime);

        if (keyboard.dKey.isPressed)
            transform.Translate(Vector3.right * velocidad * Time.deltaTime);
    }

    private void FlipControl(float h)
    {
        Vector3 escalaActual = transform.localScale;
        if (h != 0)
        {
            escalaActual.x = h > 0f ? 1f : -1f;
        }
        transform.localScale = escalaActual;
    }
}